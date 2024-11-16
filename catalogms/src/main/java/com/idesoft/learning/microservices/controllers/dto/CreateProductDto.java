package com.idesoft.learning.microservices.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CreateProductDto(
        @NotBlank @Length(min = 3) String name,
        String description,
        @NotNull Long unitMeasureId,
        Long totalStock
) {
}
