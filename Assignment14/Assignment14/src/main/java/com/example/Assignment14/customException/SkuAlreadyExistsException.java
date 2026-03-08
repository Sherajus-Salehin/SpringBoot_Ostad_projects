package com.example.Assignment14.customException;

public class SkuAlreadyExistsException extends RuntimeException{
    public SkuAlreadyExistsException(String message) {
        super(message);
    }
}
