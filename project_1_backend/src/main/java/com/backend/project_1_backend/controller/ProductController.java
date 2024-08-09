package com.backend.project_1_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project_1_backend.model.Products;
import com.backend.project_1_backend.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //GET ALL PRODUCTS ADDED IN CARTS
    @GetMapping("/products")
    public List<Products> getAllProducts(){
        return productService.getProductDetails();
    }

    //GET A PRODUCT BY PRODUCT ID
    @GetMapping("/products/{product_id}")
    public Optional<Products> getSingleProduct(@PathVariable int product_id){
        return productService.getSpecificProduct(product_id);
    }

    //ADD A PRODUCT TO THE TABLE
    @PostMapping("/products")
    public Products addProducts(@RequestBody Products products)
    {
        return productService.postProductDetails(products);
    }
}
