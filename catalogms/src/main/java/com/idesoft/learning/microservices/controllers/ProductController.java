package com.idesoft.learning.microservices.controllers;

import com.idesoft.learning.microservices.controllers.dto.CreateProductDto;
import com.idesoft.learning.microservices.controllers.dto.ProductCreatoDto;
import com.idesoft.learning.microservices.exceptions.ConflictException;
import com.idesoft.learning.microservices.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductCreatoDto> create(@Valid @RequestBody CreateProductDto request){

        try {
            Long productId = productService.save(request);

            return new ResponseEntity<>(new ProductCreatoDto(productId), HttpStatus.CREATED);
        } catch (ConflictException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
