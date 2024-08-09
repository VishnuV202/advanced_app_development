package com.backend.project_1_backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Products {
    @Id
    private int productId;
    private String category;
    private String productName;
    private String weight;
    private double price;
    private int quantity = 0;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "cart_products",joinColumns = @JoinColumn(name="product_id"),inverseJoinColumns = @JoinColumn(name="cart_id"))
    private List<Cart> carts;




}
