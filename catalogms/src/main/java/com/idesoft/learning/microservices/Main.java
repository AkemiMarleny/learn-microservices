package com.idesoft.learning.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.idesoft.learning.microservices",
})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}