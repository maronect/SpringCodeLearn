package com.maronecom.first.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationExeption extends RuntimeException {

    public UnsupportedMathOperationExeption(String ex){
        super(ex);
    }

    private static final long serialVersion = 1L;
}
