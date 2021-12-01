package com.example.apibankhours.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionError {

    @ExceptionHandler(value = {ApiRequestError.class})
    public ResponseEntity<ApiException> handleApiRequestException (ApiRequestError error) {

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
                error.getMessage(),
                error,
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );


                return new ResponseEntity<>(apiException, badRequest);
    }
}
