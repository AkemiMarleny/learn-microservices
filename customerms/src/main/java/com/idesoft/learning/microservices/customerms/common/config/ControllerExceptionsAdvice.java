package com.idesoft.learning.microservices.customerms.common.config;

import com.idesoft.learning.microservices.customerms.controllers.dto.ErrorResponse;
import com.idesoft.learning.microservices.customerms.exceptions.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionsAdvice {

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> conflicts(ConflictException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
    }
}
