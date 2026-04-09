package com.example.Assignment16.controllerTest;

import com.example.Assignment16.controller.ProductController;
import com.example.Assignment16.model.Product;
import com.example.Assignment16.service.ProductService;
import org.junit.jupiter.api.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postProduct() throws Exception {
        Product product = new Product(1L,"Mouse",10,30.40);
        when(productService.addProduct(product)).thenReturn(product);

        mockMvc.perform(post("/products")
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mouse"))
                .andExpect(jsonPath("$.price").value(30.40));

    }

    @Test
    void getProductById() throws Exception {
        Product product = new Product(1L,"Mouse",10,30.40);
        when(productService.getById(1L)).thenReturn(product);
        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mouse"));
    }
    @Test
    void getWhenNonExistant() throws Exception {
        when(productService.getById(1L))
                .thenThrow(new RuntimeException("Product found not"));
        mockMvc.perform(get("/products/1"))
                .andExpect(status().isNotFound());

    }
}
