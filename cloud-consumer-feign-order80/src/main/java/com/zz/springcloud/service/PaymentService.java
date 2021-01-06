package com.zz.springcloud.service;


import com.zz.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentService {

    @GetMapping(value = "payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") long id);
}
