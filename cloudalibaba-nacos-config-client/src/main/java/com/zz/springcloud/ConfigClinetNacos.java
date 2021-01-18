package com.zz.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClinetNacos {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClinetNacos.class, args);
    }
}
