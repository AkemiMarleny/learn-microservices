package com.idesoft.learning.microservices.exceptions;

public class RecordNotFoundException extends Exception {

    public RecordNotFoundException(String message) {
        super(message);
    }
}
