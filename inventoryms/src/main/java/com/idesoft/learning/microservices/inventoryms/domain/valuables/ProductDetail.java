package com.idesoft.learning.microservices.inventoryms.domain.valuables;

public record ProductDetail(
        Long id,
        String name,
        Long unitMeasureId,
        Long totalStock
) {
}
