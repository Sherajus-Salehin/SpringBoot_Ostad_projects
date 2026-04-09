package com.example.Assignment16.serviceTest;

import com.example.Assignment16.model.Product;
import com.example.Assignment16.repository.ProductRepo;
import com.example.Assignment16.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepo productRepo;

    @Test
    void testProductSaving(){
        Product product = new Product(1L,"Mouse",50,10.50);

        when(productRepo.save(product)).thenReturn(product);
        Product saved=productService.addProduct(product);
        assertEquals("working","Mouse",saved.getName());
        verify(productRepo).save(product);
    }
    @Test
    void getWhenExists(){
        Product product = new Product(1L,"Not Mouse",50,10.50);
        when(productRepo.findById(1L)).thenReturn(Optional.of(product));
        Product found=productService.getById(1L);
        assertEquals("working","Not Mouse",found.getName());
    }

    @Test
    void getWhenNotFound(){
        when(productRepo.findById(1L)).thenReturn(Optional.empty());
        //assertThrows(RuntimeException.class, ()-> productService.getById(1L));
        assertEquals("Lets see", "Product not found", assertThrows(RuntimeException.class, ()->productService.getById(1L)).getMessage());
    }

}
