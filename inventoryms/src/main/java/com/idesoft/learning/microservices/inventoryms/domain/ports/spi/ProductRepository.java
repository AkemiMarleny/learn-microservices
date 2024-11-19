package com.idesoft.learning.microservices.inventoryms.domain.ports.spi;

import com.idesoft.learning.microservices.inventoryms.domain.events.ProductCreatedEvent;
import com.idesoft.learning.microservices.inventoryms.domain.events.ProductModifiedEvent;
import com.idesoft.learning.microservices.inventoryms.domain.exceptions.RecordNotFoundException;

public interface ProductRepository {

    Long save(ProductCreatedEvent event);

    void update(ProductModifiedEvent event) throws RecordNotFoundException;
}
