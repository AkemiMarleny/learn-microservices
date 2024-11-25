package com.idesoft.learning.microservices.inventoryms.domain.exceptions;

public class InvalidDataException extends Exception {

    public InvalidDataException(String message) {
        super(message);
    }
}
