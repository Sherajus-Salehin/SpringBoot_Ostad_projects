package com.example.Assignment16.service;

import com.example.Assignment16.model.Product;
import com.example.Assignment16.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public Product addProduct(Product product){
        return productRepo.save(product);
    }
    public Product getById(Long id){
        return productRepo.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
    }
    public Product UpdateProduct(Long id,Integer quantity){
        Product product = getById(id);
        product.setQuantity(quantity);
        return productRepo.save(product);
    }
}
