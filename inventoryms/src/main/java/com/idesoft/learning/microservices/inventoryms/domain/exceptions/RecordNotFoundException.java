package com.idesoft.learning.microservices.inventoryms.domain.exceptions;

public class RecordNotFoundException extends Exception {

    public RecordNotFoundException(String message) {
        super(message);
    }
}
