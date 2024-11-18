package com.idesoft.learning.microservices.orderms.commands;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreatePurchaseOrderProductCommand(
        @NotNull Long productId,
        @Min(0) Long quantity
) {
}
