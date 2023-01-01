package com.product;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@Tag(name = "Students")
@OpenAPIDefinition(info =
@Info(title = "Employee API", version = "1.0", description = "Documentation Employee API v1.0")
)
public class PartnerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PartnerServiceApplication.class, args);
    }
}