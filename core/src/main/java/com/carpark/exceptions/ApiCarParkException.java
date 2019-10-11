package com.carpark.exceptions;

public class ApiCarParkException extends RuntimeException {
    public ApiCarParkException(String message) {
        super(message);
    }
}
