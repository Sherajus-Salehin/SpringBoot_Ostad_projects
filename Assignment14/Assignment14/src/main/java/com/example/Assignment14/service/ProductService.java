package com.example.Assignment14.service;

import com.example.Assignment14.customException.InvalidSkuFormatException;
import com.example.Assignment14.customException.ProductNotFoundException;
import com.example.Assignment14.customException.SkuAlreadyExistsException;
import com.example.Assignment14.model.Product;
import com.example.Assignment14.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepository pr;

    public List<Product> allProducts(){
        return pr.findAll();
    }
    public Product findProduct(Long id){
            return pr.findById(id).orElseThrow(() -> new ProductNotFoundException("not found"));
    }

    public void addProduct(Product product){
            String cSKU= product.getSku();
            if(!isValidSku(cSKU)) throw new InvalidSkuFormatException("SKU format error");
            if(isUniqueSku(cSKU)) throw new SkuAlreadyExistsException("already exists");
            pr.save(product);
    }

    public void addProducts(List<Product> products){
        // due to exception checking, I cannot use repo.saveAll here,
        // is there any more efficient way than what i have done here?
        for (Product p:products) addProduct(p);
    }

    public void updateProduct(Long id, Product p){
        Product original=findProduct(id);
        original.setName(p.getName());
        original.setDescription(p.getDescription());
        original.setPrice(p.getPrice());
        original.setQuantity(p.getQuantity());
        original.setStatus(p.getStatus());
        pr.save(original);
    }
    public void delete(Long id){
        if(pr.existsById(id)){
            pr.deleteById(id);
        }else throw new ProductNotFoundException("Does not exist");
    }



    public boolean isValidSku(String sku){
        return sku.matches("^SKU-[A-Z0-9]{8}$");
    }
    public boolean isUniqueSku(String sku){
        return pr.existsBySku(sku);
    }

}

