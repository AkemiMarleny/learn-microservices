package com.idesoft.learning.microservices.inventoryms.domain.events;

public record ProductModifiedEvent(
        Long id,
        String name,
        Long unitMeasureId,
        Long totalStock
) {
}
