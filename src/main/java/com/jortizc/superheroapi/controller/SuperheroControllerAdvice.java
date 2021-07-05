package com.jortizc.superheroapi.controller;

import com.jortizc.superheroapi.exception.ResourceNotFoundException;
import com.jortizc.superheroapi.utils.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class SuperheroControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandler (ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false)),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler (ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false)),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
