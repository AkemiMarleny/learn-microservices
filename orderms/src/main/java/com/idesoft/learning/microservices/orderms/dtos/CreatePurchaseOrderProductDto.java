package com.idesoft.learning.microservices.orderms.dtos;

public record CreatePurchaseOrderProductDto(
        Long productId,
        Long quantity
) {
}
