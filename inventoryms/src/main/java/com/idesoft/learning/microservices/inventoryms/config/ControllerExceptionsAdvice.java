package com.idesoft.learning.microservices.inventoryms.config;

import com.idesoft.learning.microservices.inventoryms.adapters.http.dto.ErrorResponse;
import com.idesoft.learning.microservices.inventoryms.domain.exceptions.InvalidDataException;
import com.idesoft.learning.microservices.inventoryms.domain.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionsAdvice {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFound(RecordNotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorResponse> invalidData(InvalidDataException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
