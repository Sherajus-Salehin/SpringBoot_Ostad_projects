package com.example.Assignment14.customException;

public class SkuAlreadyExistsException extends RuntimeException{
    String sku;
    public SkuAlreadyExistsException(String message,String sku) {
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
