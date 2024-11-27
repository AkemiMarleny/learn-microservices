package com.idesoft.learning.microservices.inventoryms.domain.events;

public record ProductStockModifiedEvent(
        Long productId,
        Long totalStock
) {
}
