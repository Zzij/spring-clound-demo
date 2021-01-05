package com.zz.springcloud.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
