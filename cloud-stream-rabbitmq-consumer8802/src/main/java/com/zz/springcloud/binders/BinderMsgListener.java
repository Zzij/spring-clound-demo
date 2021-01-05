package com.zz.springcloud.binders;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
@Slf4j
public class BinderMsgListener {

    @StreamListener(Sink.INPUT)
    public void receiver(Message<String> message) {
        log.info("receive msg {}", message.getPayload());
    }
}
