package com.zz.springcloud.controller;

import com.zz.springcloud.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private PayService payService;

    @GetMapping("consumer/pay/timeout")
    public String payTimeout(){
        return payService.payTimeout();
    }

    @GetMapping("consumer/pay/error")
    public String payError(){
        return payService.payError(1);
    }

    @GetMapping("consumer/pay/ok")
    public String payOk(){
        return payService.payOk(2);
    }
}
