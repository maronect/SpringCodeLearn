package com.maronecom.first.exceptions.handler;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.maronecom.first.exceptions.ExeptionResponse;
import com.maronecom.first.exceptions.ResourseNotFoundException;

@ControllerAdvice //para concentrar um tratamento que seria passado para outros controllers
@RestController
public class CustimizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExeptionResponse> handlerAllExeptions(Exception ex, WebRequest request) {
        ExeptionResponse exeptionResponse = new ExeptionResponse(new Date(0), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exeptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(ResourseNotFoundException.class)
    public final ResponseEntity<ExeptionResponse> handlerNotFoundExeptions(Exception ex, WebRequest request) {
        ExeptionResponse exeptionResponse = new ExeptionResponse(new Date(0), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exeptionResponse, HttpStatus.NOT_FOUND);
    }
}