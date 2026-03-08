package com.example.Assignment14.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Must not be blank.")
    private String name;
    @Size(max=500, message = "Optional, but if present, must be no longer than 500 characters")
    private String description;
    @NotBlank(message = "Must not be blank")
    private final String sku;
    @NotNull
    @Positive(message = "Must not be null and must be a positive number")
    private double price;
    @Min(0)
    @Positive(message = "Must not be null and must be zero or more")
    private int quantity;
    @NotNull(message = "Must not be blank")
    private ProductStatus status;

    public Product() {
        this.sku="";
    }

    public Product(String name, String description, String sku, double price, int quantity, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.sku = sku;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public @NotBlank(message = "Must not be blank.") String getName() {
        return name;
    }

    public @Size(max = 500, message = "Optional, but if present, must be no longer than 500 characters") String getDescription() {
        return description;
    }

    public @NotBlank(message = "Must not be blank") String getSku() {
        return sku;
    }

    @NotNull
    @Positive(message = "Must not be null and must be a positive number")
    public double getPrice() {
        return price;
    }

    @Min(0)
    @Positive(message = "Must not be null and must be zero or more")
    public int getQuantity() {
        return quantity;
    }

    public @NotNull(message = "Must not be blank") ProductStatus getStatus() {
        return status;
    }

    public void setName(@NotBlank(message = "Must not be blank.") String name) {
        this.name = name;
    }

    public void setDescription(@Size(max = 500, message = "Optional, but if present, must be no longer than 500 characters") String description) {
        this.description = description;
    }

    public void setPrice(@NotNull @Positive(message = "Must not be null and must be a positive number") double price) {
        this.price = price;
    }

    public void setQuantity(@Min(0) @Positive(message = "Must not be null and must be zero or more") int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(@NotNull(message = "Must not be blank") ProductStatus status) {
        this.status = status;
    }
}
