package com.idesoft.learning.microservices.controllers;

import com.idesoft.learning.microservices.controllers.dto.CreateProductDto;
import com.idesoft.learning.microservices.controllers.dto.ProductCreatoDto;
import com.idesoft.learning.microservices.controllers.dto.UpdateProductDto;
import com.idesoft.learning.microservices.exceptions.ConflictException;
import com.idesoft.learning.microservices.exceptions.RecordNotFoundException;
import com.idesoft.learning.microservices.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductCreatoDto> create(@Valid @RequestBody CreateProductDto request) throws ConflictException {

        Long productId = productService.save(request);

        return new ResponseEntity<>(new ProductCreatoDto(productId), HttpStatus.CREATED);

    }

    @PutMapping("{productId}")
    public ResponseEntity<Void> update(@PathVariable Long productId, @Valid @RequestBody UpdateProductDto request) throws RecordNotFoundException, ConflictException {

        productService.update(productId, request);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
