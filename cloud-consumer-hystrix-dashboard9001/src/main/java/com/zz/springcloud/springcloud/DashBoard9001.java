package com.zz.springcloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashBoard9001 {
    public static void main(String[] args) {
        //http://localhost:9001/hystrix 监控地址
        SpringApplication.run(DashBoard9001.class, args);
    }
}
