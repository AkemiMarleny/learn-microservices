package com.idesoft.learning.microservices.controllers;

import com.idesoft.learning.microservices.common.RabbitMqSender;
import com.idesoft.learning.microservices.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product-catalogs")
public class ProductCatalogController {

    private final RabbitMqSender rabbitMqSender;

    @GetMapping
    ResponseEntity<String> sayHello() {

        Product productDemo = new Product(1L, "Product Name");

        rabbitMqSender.send(productDemo);

        return ResponseEntity.ok("Mensaje enviado");
    }
}
