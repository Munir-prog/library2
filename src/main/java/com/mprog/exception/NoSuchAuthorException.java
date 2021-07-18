package com.mprog.exception;

import com.mprog.validator.Error;

import java.util.List;

public class NoSuchAuthorException extends RuntimeException{
    @Override
    public String getMessage() {
        return super.getMessage() + "No such Author";
    }
}
