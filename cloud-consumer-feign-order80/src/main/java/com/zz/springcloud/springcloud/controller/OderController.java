package com.zz.springcloud.springcloud.controller;


import com.zz.springcloud.springcloud.entities.CommonResult;
import com.zz.springcloud.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment")
    public CommonResult getPayment(@RequestParam("id") long id){
        return paymentService.getPaymentById(id);
    }
}
