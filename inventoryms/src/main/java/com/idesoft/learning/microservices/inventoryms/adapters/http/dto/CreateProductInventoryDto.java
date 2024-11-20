package com.idesoft.learning.microservices.inventoryms.adapters.http.dto;

public record CreateProductInventoryDto(
        Long productId,
        Long quantity
) {
}
