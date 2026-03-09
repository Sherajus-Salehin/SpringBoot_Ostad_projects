package com.example.Assignment14.controller;

import com.example.Assignment14.model.Product;
import com.example.Assignment14.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    ProductService ps;

    @GetMapping("/test")
    public String test() {
        return "<h1>its</h1><br> <h2>working</h2>";
    }


    //POST /: Creates a new product.
    @PostMapping
    public void addProduct(@RequestBody Product p) {
        log.debug("Received request to create product: {}", p);
        ps.addProduct(p);
    }

    @GetMapping
    public List<Product> getProducts() {
        log.debug("Received request to show all products");
        return ps.allProducts();

    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) {
        log.debug("Received request to show the product with id: {}",id);
        return ps.findProduct(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable long id, @RequestBody Product p) {
        log.debug("Received request to update the product with id: {}",id);
        ps.updateProduct(id, p);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable long id) {
        log.debug("Received request to delete the product with id: {}",id);
        ps.delete(id);
    }


}
