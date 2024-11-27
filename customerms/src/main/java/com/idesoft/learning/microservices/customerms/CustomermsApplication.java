package com.idesoft.learning.microservices.customerms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.idesoft.learning.microservices.customerms"})
public class CustomermsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomermsApplication.class, args);
    }

}
