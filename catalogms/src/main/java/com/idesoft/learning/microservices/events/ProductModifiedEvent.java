package com.idesoft.learning.microservices.events;

public record ProductModifiedEvent(
        Long id,
        String name,
        Long unitMeasureId,
        Long totalStock
) {
}
