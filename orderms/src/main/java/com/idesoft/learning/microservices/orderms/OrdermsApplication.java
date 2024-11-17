package com.idesoft.learning.microservices.orderms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.idesoft.learning.microservices.orderms",
})
public class OrdermsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdermsApplication.class, args);
    }

}
