package com.idesoft.learning.microservices.orderms.events;

public record ProductCreatedEvent(
        Long id,
        String name,
        Long unitMeasureId,
        Long totalStock
) {
}
