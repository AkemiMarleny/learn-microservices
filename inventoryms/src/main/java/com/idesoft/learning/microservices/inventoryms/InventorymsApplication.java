package com.idesoft.learning.microservices.inventoryms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.idesoft.learning.microservices.inventoryms",})
public class InventorymsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventorymsApplication.class, args);
    }

}
