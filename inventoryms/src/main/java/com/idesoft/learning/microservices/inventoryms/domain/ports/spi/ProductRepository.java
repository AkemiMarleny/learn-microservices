package com.idesoft.learning.microservices.inventoryms.domain.ports.spi;

import com.idesoft.learning.microservices.inventoryms.domain.events.ProductCreatedEvent;
import com.idesoft.learning.microservices.inventoryms.domain.events.ProductModifiedEvent;
import com.idesoft.learning.microservices.inventoryms.domain.exceptions.RecordNotFoundException;
import com.idesoft.learning.microservices.inventoryms.domain.valuables.ProductDetail;

import java.util.Optional;

public interface ProductRepository {

    Long save(ProductCreatedEvent event);

    void update(ProductModifiedEvent event) throws RecordNotFoundException;

    Optional<ProductDetail> findById(Long productId);
}
