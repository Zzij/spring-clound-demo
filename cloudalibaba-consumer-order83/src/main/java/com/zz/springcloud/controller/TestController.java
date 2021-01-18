package com.zz.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String PAY_SERVER_URL = "http://cloud-nacos-provider-service";

    @GetMapping("consumer/pay")
    public String getPay(){
        return restTemplate.getForObject(PAY_SERVER_URL + "/pay/nacos", String.class);
    }
}