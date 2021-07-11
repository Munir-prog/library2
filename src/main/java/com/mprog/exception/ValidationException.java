package com.mprog.exception;

import com.mprog.validator.Error;

import java.util.List;

public class ValidationException extends RuntimeException{
    private final List<Error> errorList;

    public ValidationException(List<Error> errorList) {
        this.errorList = errorList;
    }

    public List<Error> getErrorList() {
        return errorList;
    }
}
