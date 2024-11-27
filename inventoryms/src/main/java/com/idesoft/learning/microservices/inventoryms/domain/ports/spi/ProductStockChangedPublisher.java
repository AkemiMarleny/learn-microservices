package com.idesoft.learning.microservices.inventoryms.domain.ports.spi;

import com.idesoft.learning.microservices.inventoryms.domain.events.ProductStockModifiedEvent;

public interface ProductStockChangedPublisher {

    void publish(ProductStockModifiedEvent event);
}
