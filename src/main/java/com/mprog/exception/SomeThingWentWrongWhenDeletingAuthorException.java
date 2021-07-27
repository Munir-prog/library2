package com.mprog.exception;

public class SomeThingWentWrongWhenDeletingAuthorException extends RuntimeException {
    private final String message = """
            Something went wrong!        
            Please check the name or surname.
            """;

    @Override
    public String getMessage() {
        return message;
    }
}
