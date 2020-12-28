package com.zz.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zz.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


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


    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期,多久内尝试恢复
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率多少熔断

    })
    public String paymentCircuitBreaker(Integer id) {

        if(id < 0){
            throw  new RuntimeException("error");
        }

        return Thread.currentThread().getName() + "调用成功!!";
    }

    public String paymentCircuitBreakerHandler(Integer id){
        return Thread.currentThread().getName() + " 不能为负数调用失败!!";
    }
}
