package com.zz.springcloud.springcloud.service;

import com.zz.springcloud.springcloud.entities.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(long id);
}
