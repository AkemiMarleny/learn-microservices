package com.idesoft.learning.microservices.inventoryms.domain.valuables;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateProductInventory(
        @NotNull Long productId,
        @Min(0) Long quantity
) {
}
