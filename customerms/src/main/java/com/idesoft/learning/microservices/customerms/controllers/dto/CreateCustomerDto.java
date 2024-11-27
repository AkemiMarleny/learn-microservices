package com.idesoft.learning.microservices.customerms.controllers.dto;

public record CreateCustomerDto(
        String firstName,
        String lastName,
        Long documentTypeId,
        String documentNumber
) {
}
