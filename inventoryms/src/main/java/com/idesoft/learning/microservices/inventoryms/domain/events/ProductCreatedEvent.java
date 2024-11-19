package com.idesoft.learning.microservices.inventoryms.domain.events;

public record ProductCreatedEvent(
        Long id,
        String name,
        Long unitMeasureId,
        Long totalStock
) {
}
