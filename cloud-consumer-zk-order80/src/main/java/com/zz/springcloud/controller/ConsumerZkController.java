package com.zz.springcloud.controller;


import com.zz.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerZkController {

    public static final String INVOKE_URL="http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("zk")
    public CommonResult getPayment(){
        CommonResult commonResult = restTemplate.getForObject(INVOKE_URL + "/payment/get/1", CommonResult.class);
        return commonResult;
    }
}
