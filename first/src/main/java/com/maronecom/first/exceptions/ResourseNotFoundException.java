package com.maronecom.first.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException {
    private static final long serialVersion = 1L;

    public ResourseNotFoundException(String ex){
        super(ex);
    }
}
