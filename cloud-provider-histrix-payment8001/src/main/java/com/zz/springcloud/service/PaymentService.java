package com.zz.springcloud.service;

public interface PaymentService {

    String paymentOk(Integer id);

    String paymentError(Integer id);

    String paymentTimeout();

    String paymentCircuitBreaker(Integer id);
}
