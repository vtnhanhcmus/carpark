package com.carpark.exceptions;

import org.springframework.validation.Errors;

public class InvalidResourceException extends RuntimeException {

    Errors errors;

    public InvalidResourceException(Errors errors) {
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }
}
