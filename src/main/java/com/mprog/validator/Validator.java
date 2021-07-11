package com.mprog.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);

}
