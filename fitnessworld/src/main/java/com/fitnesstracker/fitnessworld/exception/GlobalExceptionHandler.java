package com.fitnesstracker.fitnessworld.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice 
public class GlobalExceptionHandler {

@ExceptionHandler(RuntimeException.class) 
public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST); // 400 Bad Request
}

@ExceptionHandler(Exception.class) 
public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
}

}