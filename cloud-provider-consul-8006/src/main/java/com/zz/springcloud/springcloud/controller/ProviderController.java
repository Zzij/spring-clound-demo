package com.zz.springcloud.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProviderController {

    @GetMapping("consul")
    public String providerConsul(){
        return "test consul " + UUID.randomUUID().toString();
    }
}
