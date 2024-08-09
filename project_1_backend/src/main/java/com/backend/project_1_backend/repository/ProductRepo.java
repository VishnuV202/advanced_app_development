package com.backend.project_1_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.project_1_backend.model.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products,Integer>{

    
}
