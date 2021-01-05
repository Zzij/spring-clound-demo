package com.zz.springcloud.springcloud.service.impl;

import com.zz.springcloud.springcloud.service.MsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class)
public class MsgSenderImpl implements MsgSender {

    //名字必须为output  否则无法注入bean
    @Autowired
    private MessageChannel output;

    @Override
    public String sendMsg() {
        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        return s;
    }
}
