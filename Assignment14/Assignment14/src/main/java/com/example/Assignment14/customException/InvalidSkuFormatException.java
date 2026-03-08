package com.example.Assignment14.customException;

public class InvalidSkuFormatException extends RuntimeException{
    public InvalidSkuFormatException(String message) {
        super(message);
    }
}
