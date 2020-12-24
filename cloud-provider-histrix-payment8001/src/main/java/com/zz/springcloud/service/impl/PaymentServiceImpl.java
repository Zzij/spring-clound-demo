package com.zz.springcloud.service.impl;

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
    public String paymentTimeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + " sleep 3s";
    }
}
