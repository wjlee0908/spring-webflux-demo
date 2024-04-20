package com.woojin.webfluxdemo.common;

import com.woojin.webfluxdemo.common.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception exp) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiResponse response = ApiResponse.builder().code(httpStatus.value()).message(exp.getMessage()).build();

        return new ResponseEntity<>(response, httpStatus);
    }
}
