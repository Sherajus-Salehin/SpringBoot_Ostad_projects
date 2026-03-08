package com.example.Assignment14.controller;

import com.example.Assignment14.model.Product;
import com.example.Assignment14.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService ps;

    @GetMapping("/test")
    public String test(){
        return "<h1>its</h1><br> <h2>working</h2>";
    }


    //POST /: Creates a new product.
@PostMapping
    public void addProduct(@RequestBody Product p){
        ps.addProduct(p);
}

@GetMapping
    public List<Product> getProducts(){
        return ps.allProducts();

}


//GET /: Returns a list of all products.

//GET /{id}: Returns a single product by its ID.

//PUT /{id}: Updates an existing product.

//DELETE /{id}: Deletes a product by its ID.


}
