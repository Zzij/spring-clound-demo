package com.zz.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PayService {

    @GetMapping("/pay/timeout")
    String payTimeout();

    @GetMapping("/pay/error")
    String payError(@RequestParam("id") Integer id);

    @GetMapping("/pay/ok")
    String payOk(@RequestParam("id") Integer id);
}
