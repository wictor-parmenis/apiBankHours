package com.example.apibankhours.Exception;

public class ApiRequestError extends RuntimeException {

    public ApiRequestError (String message) {
        super(message);
    }

    public ApiRequestError (String message, Throwable cause) {
        super(message, cause);
    }}
