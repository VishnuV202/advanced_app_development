package com.backend.project_1_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.project_1_backend.model.Products;
import com.backend.project_1_backend.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Products> getProductDetails()
    {
        return productRepo.findAll();
    }

    public Optional<Products> getSpecificProduct(int id)
    {
        return productRepo.findById(id);
    }

    public Products postProductDetails(Products products)
    {
        return productRepo.save(products);
    }
}
