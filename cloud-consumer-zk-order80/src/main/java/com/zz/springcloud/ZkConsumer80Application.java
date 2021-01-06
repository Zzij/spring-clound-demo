package com.zz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZkConsumer80Application {
    public static void main(String[] args) {
        SpringApplication.run(ZkConsumer80Application.class, args);
    }
}
