package com.carpark.rest.advice;

import com.carpark.exceptions.PagingException;
import com.carpark.rest.response.errors.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BusinessAdviceController {

    @ExceptionHandler({ PagingException.class })
    public ResponseEntity<Object> handlePaging(PagingException ex) {
        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

}
