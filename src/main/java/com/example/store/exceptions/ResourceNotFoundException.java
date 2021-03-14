package com.example.store.exceptions;

public class ResourceNotFoundException extends ApplicationException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
