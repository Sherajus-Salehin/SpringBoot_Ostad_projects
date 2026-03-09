package com.example.Assignment14.service;

import com.example.Assignment14.customException.InvalidSkuFormatException;
import com.example.Assignment14.customException.ProductNotFoundException;
import com.example.Assignment14.customException.SkuAlreadyExistsException;
import com.example.Assignment14.model.Product;
import com.example.Assignment14.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    ProductRepository pr;

    public List<Product> allProducts(){
        return pr.findAll();
    }
    public Product findProduct(Long id){
            return pr.findById(id).orElseThrow(() -> new ProductNotFoundException("not found",id));
    }

    public void addProduct(Product product){
            String cSKU= product.getSku();
            if(!isValidSku(cSKU)) throw new InvalidSkuFormatException("SKU format error");
            if(isUniqueSku(cSKU)) throw new SkuAlreadyExistsException("already exists");
            Product saved=pr.save(product);
            log.info("Product created with ID: {} and SKU: {}", saved.getId(), saved.getSku());
    }

    public void addProducts(List<Product> products){
        // due to validation, I cannot use repo.saveAll here,
        // is there any more efficient way than what i have done here?
        for (Product p:products) addProduct(p);
    }

    public void updateProduct(Long id, Product p){
        Product updated=findProduct(id);
        updated.setName(p.getName());
        updated.setDescription(p.getDescription());
        updated.setPrice(p.getPrice());
        updated.setQuantity(p.getQuantity());
        updated.setStatus(p.getStatus());
        Product saved=pr.save(updated);
        log.info("Product updated with SKU: {}  " +
                "\nUpdated:" +
                "\nname: {}"+
                "\nDescription: {}" +
                "\nPrice: {} " +
                "\nQuantity: {} " +
                "\nStatus: {}  " +
                "\nID: {} " ,
                saved.getSku(),saved.getName(),saved.getDescription(),saved.getPrice(),saved.getQuantity(),saved.getStatus(),saved.getId());
    }
    public void delete(Long id){
        if(pr.existsById(id)){
            pr.deleteById(id);
            log.info("Product deleted with ID: {}", id);
        }else throw new ProductNotFoundException("Does not exist",id);
    }



    public boolean isValidSku(String sku){
        return sku.matches("^SKU-[A-Z0-9]{8}$");
    }
    public boolean isUniqueSku(String sku){
        return pr.existsBySku(sku);
    }

}

