package com.example.Assignment14.customException;

public class InvalidSkuFormatException extends RuntimeException{
String sku;
    public InvalidSkuFormatException(String message, String sku) {
        super(message);
        this.sku=sku;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
