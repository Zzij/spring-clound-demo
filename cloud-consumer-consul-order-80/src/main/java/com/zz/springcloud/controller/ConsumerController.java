package com.zz.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private static final String INVOKE_URL = "http://cloud-payment-consul-service";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping()
    public String getConsul(){
        return restTemplate.getForObject(INVOKE_URL + "/consul", String.class);
    }
}
