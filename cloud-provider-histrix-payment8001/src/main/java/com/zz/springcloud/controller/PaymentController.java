package com.zz.springcloud.controller;


import com.zz.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/pay/ok")
    public String payOk(@RequestParam("id") Integer id){
        return paymentService.paymentOk(id);
    }

    @GetMapping("/pay/error")
    public String payError(@RequestParam("id") Integer id){
        return paymentService.paymentError(id);
    }


    @GetMapping("/pay/timeout")
    public String payTimeout(){
        return paymentService.paymentTimeout();
    }

    @GetMapping("pay/circuit/{id}")
    public String payCircuit(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }

    @GetMapping("/payment/get")
    public String payGet(){
        return "get success";
    }

    @GetMapping("/payment/lb")
    public String payLb(){
        return "lb success";
    }
}
