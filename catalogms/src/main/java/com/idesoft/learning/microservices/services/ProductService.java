package com.idesoft.learning.microservices.services;

import com.idesoft.learning.microservices.controllers.dto.CreateProductDto;
import com.idesoft.learning.microservices.controllers.dto.UpdateProductDto;
import com.idesoft.learning.microservices.entities.Product;
import com.idesoft.learning.microservices.events.ProductCreatedEvent;
import com.idesoft.learning.microservices.events.ProductModifiedEvent;
import com.idesoft.learning.microservices.exceptions.ConflictException;
import com.idesoft.learning.microservices.exceptions.RecordNotFoundException;
import com.idesoft.learning.microservices.messages.ProductMessage;
import com.idesoft.learning.microservices.repositories.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Validated
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMessage productMessage;

    public Long save(@Valid CreateProductDto payload) throws ConflictException {

        Product product = Product.from(payload);

        Long productCounter = productRepository.countByChecksum(product.getChecksum());

        if (productCounter > 0) {
            throw new ConflictException("Product already exist");
        }

        productRepository.save(product);

        productMessage.send(new ProductCreatedEvent(
                product.getId(),
                product.getName(),
                product.getUnitMeasureId(),
                product.getTotalStock()));

        return product.getId();

    }

    public void update(Long productId, @Valid UpdateProductDto payload) throws RecordNotFoundException, ConflictException {

        Optional<Product> productOpt = productRepository.findById(productId);

        if (productOpt.isEmpty()) {
            throw new RecordNotFoundException();
        }

        Product productToModified = productOpt.get();

        productToModified.updateWith(payload);

        Long productCounter = productRepository.countByChecksumAndIdNotIn(productToModified.getChecksum(), Arrays.asList(productId));

        if (productCounter > 0) {
            throw new ConflictException("Product already exist");
        }

        productRepository.save(productToModified);

        productMessage.send(new ProductModifiedEvent(
                productToModified.getId(),
                productToModified.getName(),
                productToModified.getUnitMeasureId(),
                productToModified.getTotalStock()
        ));

    }

}
