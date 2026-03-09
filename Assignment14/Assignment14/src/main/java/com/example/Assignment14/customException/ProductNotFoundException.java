package com.example.Assignment14.customException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductNotFoundException extends RuntimeException{
    Long id;
    public ProductNotFoundException(String message, long id) {
        super(message);
        this.id=id;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
