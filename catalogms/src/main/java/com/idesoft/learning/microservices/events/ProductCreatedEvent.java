package com.idesoft.learning.microservices.events;

public record ProductCreatedEvent(
        Long id,
        String name,
        Long unitMeasureId,
        Long totalStock
) {
}
