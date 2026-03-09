package com.example.Assignment14.controller;

import com.example.Assignment14.customException.InvalidSkuFormatException;
import com.example.Assignment14.customException.ProductNotFoundException;
import com.example.Assignment14.customException.SkuAlreadyExistsException;
import com.example.Assignment14.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNoFound(ProductNotFoundException e){
        log.warn("Failed to find product with id: {}",e.getId());
        ErrorResponse erm=new ErrorResponse(LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(erm, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidSkuFormatException.class)
    public ResponseEntity<?> handleInvalidSku(InvalidSkuFormatException e){
        ErrorResponse erm=new ErrorResponse(LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(erm, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SkuAlreadyExistsException.class)
    public ResponseEntity<?> copySKU(SkuAlreadyExistsException e){
        ErrorResponse erm=new ErrorResponse(LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(erm, HttpStatus.CONFLICT);
    }

    public  ResponseEntity<?> invalidBean(MethodArgumentNotValidException e){
        ErrorResponse erm=new ErrorResponse(LocalDateTime.now(),e.getMessage());
        return new ResponseEntity<>(erm,HttpStatus.BAD_REQUEST);
    }
}
