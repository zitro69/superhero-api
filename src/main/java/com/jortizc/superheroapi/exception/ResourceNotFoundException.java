package com.jortizc.superheroapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException (String message) {
        super(message);
    }
}
