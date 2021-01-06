package com.zz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamRabbit8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbit8801.class, args);
    }
}
