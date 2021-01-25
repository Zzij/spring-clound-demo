package com.zz.springcloud.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("testa")
    public String testA(){
        return "A";
    }

    @GetMapping("testb")
    public String testB(){
        return "B";
    }
}
