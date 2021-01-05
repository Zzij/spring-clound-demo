package com.zz.springcloud.springcloud.controller;


import com.zz.springcloud.springcloud.service.MsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

    @Autowired
    private MsgSender msgSender;

    @GetMapping("test")
    public String msgTest(){
        return msgSender.sendMsg();
    }
}
