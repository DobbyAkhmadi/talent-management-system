package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayMicroService {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayMicroService.class, args);
    }
}