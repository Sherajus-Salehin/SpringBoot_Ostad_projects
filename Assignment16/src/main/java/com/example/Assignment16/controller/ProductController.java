package com.example.Assignment16.controller;

import com.example.Assignment16.model.Product;
import com.example.Assignment16.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping()
    Product postProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/{id}")
    Product getProduct(@PathVariable Long id){
        return productService.getById(id);
    }

    @PutMapping("/{id}/stock")
    Product updateProduct(@PathVariable Long id, @RequestBody Integer quantity){
        return productService.UpdateProduct(id, quantity);
    }
}
