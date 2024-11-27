package com.idesoft.learning.microservices.customerms.valuables;

import com.idesoft.learning.microservices.customerms.common.helpers.Sum;
import com.idesoft.learning.microservices.customerms.controllers.dto.CreateCustomerDto;

public class CustomerChecksum {
    private final String checksum;

    public CustomerChecksum(CreateCustomerDto request) {
        this.checksum = Sum.fromContent(fingerprint(request));
    }

    private String fingerprint(CreateCustomerDto request) {
        return String.format("%s.%s.%s.%s",
                request.firstName(),
                request.lastName(),
                request.documentTypeId(),
                request.documentNumber()).toLowerCase().trim();
    }

    public String get() {
        return checksum;
    }

}
