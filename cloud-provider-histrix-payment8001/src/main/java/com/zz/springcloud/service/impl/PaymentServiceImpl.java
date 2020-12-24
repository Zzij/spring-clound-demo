package com.zz.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zz.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentOk(Integer id) {
        return Thread.currentThread().getName() + " payment ok, id " + id;
    }

    @Override
    public String paymentError(Integer id) {
        int i = 1 / 0;
        return "haha";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentHystrixHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") //服务方超时时间
    })
    public String paymentTimeout() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + " sleep 3s";
    }

    public String paymentHystrixHandler() {
        return Thread.currentThread().getName() + " paymentHystrixHandler error";
    }
}
