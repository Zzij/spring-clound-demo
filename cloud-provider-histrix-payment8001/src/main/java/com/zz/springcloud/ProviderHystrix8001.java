package com.zz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrix8001.class, args);
    }
}
