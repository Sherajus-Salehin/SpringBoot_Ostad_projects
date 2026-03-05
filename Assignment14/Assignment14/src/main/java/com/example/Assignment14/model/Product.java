package com.example.Assignment14.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Mandatory field")
    private String name;
    @Size(max=500, message = "limit: 500 characters!")
    private String description;
    @NotBlank(message = "Mandatory field")
    private String sku;
    @NotNull
    @Positive(message = "must be a positive number")
    private double price;
    @Min(0)
    @Positive
    private int quantity;
    @NotNull
    private ProductStatus status;
}
