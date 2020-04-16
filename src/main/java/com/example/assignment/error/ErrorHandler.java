package com.example.assignment.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Rudimentary error handling with restricted client visibility and some context logging

@RestControllerAdvice
public class ErrorHandler {
	
	private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);
 
    @ExceptionHandler(PermissionError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleCustomException(PermissionError ce) {
    	log.error("Permission error was thrown", ce.toString());
        return ce.getMessage();
    }
    
    @ExceptionHandler(InvalidRequestError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleCustomException(InvalidRequestError ce) {
        return ce.getMessage();
    }
    
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleCustomException(Throwable ce) {
    	log.error("Unspecified error was thrown", ce.toString());
        return "There was an error. Please try again later";
    }
 
}
