package com.idesoft.learning.microservices.inventoryms.domain.valuables;

public record SaveProductInventory(
        Long productId,
        Long quantity
) {
}
