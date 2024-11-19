package com.idesoft.learning.microservices.inventoryms.adapters.repositories;

import com.idesoft.learning.microservices.inventoryms.adapters.repositories.dao.readonly.Product;
import com.idesoft.learning.microservices.inventoryms.adapters.repositories.jpa.JpaProductRepository;
import com.idesoft.learning.microservices.inventoryms.domain.events.ProductCreatedEvent;
import com.idesoft.learning.microservices.inventoryms.domain.ports.spi.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    @Override
    public Long save(ProductCreatedEvent event) {
        return jpaProductRepository.save(Product.from(event)).getId();
    }
}
