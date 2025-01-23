package com.workintech.s18d2.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(PlantException exception){
        log.error("plant exception occured! Exception details: ", exception);
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, exception.getHttpStatus());
    }


    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(Exception exception){
        log.error("exception occured! Exception details: ", exception);
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
