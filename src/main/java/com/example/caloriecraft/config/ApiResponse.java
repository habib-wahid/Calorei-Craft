package com.example.caloriecraft.config;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    private final HttpStatus httpStatus;
    private String message;

    public ApiResponse(String message) {
        this.message = message;
        this.httpStatus = HttpStatus.OK;
    }

    public ApiResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
