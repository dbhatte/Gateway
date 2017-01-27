package com.devendra.gateway.controller;

/**
 * Created by devendra on 27/01/2017.
 */

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devendra.gateway.model.ErrorMessage;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception e, HttpServletRequest request) {
        String errorURL = request.getRequestURL().toString();
        ErrorMessage errorInfo = new ErrorMessage(errorURL, e.getMessage());
        HttpHeaders headers = getHttpHeaders();
        return new ResponseEntity<Object>(errorInfo, headers, HttpStatus.BAD_REQUEST);
    }


    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return headers;
    }

}