package com.idesoft.learning.microservices.inventoryms.adapters.repositories;

import com.idesoft.learning.microservices.inventoryms.adapters.repositories.dao.readonly.Product;
import com.idesoft.learning.microservices.inventoryms.adapters.repositories.factories.ProductFactory;
import com.idesoft.learning.microservices.inventoryms.adapters.repositories.jpa.JpaProductRepository;
import com.idesoft.learning.microservices.inventoryms.domain.events.ProductCreatedEvent;
import com.idesoft.learning.microservices.inventoryms.domain.events.ProductModifiedEvent;
import com.idesoft.learning.microservices.inventoryms.domain.exceptions.RecordNotFoundException;
import com.idesoft.learning.microservices.inventoryms.domain.ports.spi.ProductRepository;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.ProductDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    @Override
    public Long save(ProductCreatedEvent event) {
        return jpaProductRepository.save(Product.from(event)).getId();
    }

    @Override
    public void update(ProductModifiedEvent event) throws RecordNotFoundException {
        Product product = jpaProductRepository.findById(event.id()).orElseThrow(() -> new RecordNotFoundException(String.format("Warehouse with id %s not found", event.id())));

        product.updateWith(event);

        jpaProductRepository.save(product);
    }

    @Override
    public Optional<ProductDetail> findById(Long productId) {
        return jpaProductRepository.findById(productId).map(ProductFactory::productDetailFrom);
    }
}
