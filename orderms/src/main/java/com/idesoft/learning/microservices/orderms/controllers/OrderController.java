package com.idesoft.learning.microservices.orderms.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @GetMapping
    ResponseEntity<String> sayHello(){

        return ResponseEntity.ok("Mensaje enviado");
    }
}
