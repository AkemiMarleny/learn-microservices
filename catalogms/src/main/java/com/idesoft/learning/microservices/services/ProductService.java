package com.idesoft.learning.microservices.services;

import com.idesoft.learning.microservices.controllers.dto.CreateProductDto;
import com.idesoft.learning.microservices.entities.Product;
import com.idesoft.learning.microservices.exceptions.ConflictException;
import com.idesoft.learning.microservices.repositories.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class ProductService {

    private final ProductRepository productRepository;

    public Long save(@Valid CreateProductDto payload) throws ConflictException {

        Product product = Product.from(payload);

        Long productContatore = productRepository.countByChecksum(product.getChecksum());

        if (productContatore > 0){
            throw new ConflictException();
        }

        return productRepository.save(Product.from(payload)).getId();
    }

}
