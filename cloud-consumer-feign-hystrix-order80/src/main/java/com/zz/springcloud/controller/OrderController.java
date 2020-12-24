package com.zz.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zz.springcloud.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "consumerGlobalHystrixHandler")
public class OrderController {

    @Autowired
    private PayService payService;

    @GetMapping("consumer/pay/timeout")
    @HystrixCommand(fallbackMethod = "consumerHystrixHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") //超时时间
    })
    public String payTimeout(){
        return payService.payTimeout();
    }

    @GetMapping("consumer/pay/error")
    @HystrixCommand
    public String payError(){
        return payService.payError(1);
    }

    @GetMapping("consumer/pay/ok")
    public String payOk(){
        return payService.payOk(2);
    }

    public String consumerHystrixHandler(){
        return "服务端有问题，客户端降级处理";
    }

    public String consumerGlobalHystrixHandler(){
        return "全局处理，客户端降级处理";
    }
}
