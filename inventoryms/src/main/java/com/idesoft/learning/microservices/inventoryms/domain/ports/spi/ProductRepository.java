package com.idesoft.learning.microservices.inventoryms.domain.ports.spi;

import com.idesoft.learning.microservices.inventoryms.domain.events.ProductCreatedEvent;

public interface ProductRepository {

    Long save(ProductCreatedEvent event);
}
