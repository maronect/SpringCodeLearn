package com.maronecom.first.exceptions;

import java.io.Serializable;
import java.sql.Date;

public class ExeptionResponse implements Serializable {
    private static final long serialVersion = 1L;
    private Date erroTime;
    private String message;
    private String details;
    
    public ExeptionResponse(Date erroTime, String message, String details) {
        this.erroTime = erroTime;
        this.message = message;
        this.details = details;
    }

    public Date getErroTime() {
        return erroTime;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
