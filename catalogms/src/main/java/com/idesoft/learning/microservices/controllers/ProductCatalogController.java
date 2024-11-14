package com.idesoft.learning.microservices.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product-catalog")
public class ProductCatalogController {

    @GetMapping
    ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("{\"message\": \"hello\"}");
    }
}
