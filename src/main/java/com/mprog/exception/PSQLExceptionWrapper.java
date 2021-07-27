package com.mprog.exception;

import org.postgresql.util.PSQLException;

public class PSQLExceptionWrapper extends RuntimeException {

    private final String message;

    public PSQLExceptionWrapper(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
