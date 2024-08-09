package com.backend.project_1_backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.project_1_backend.model.Cart;
import com.backend.project_1_backend.model.Products;
import com.backend.project_1_backend.repository.CartRepo;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;

    //GETTING ALL THE CARTS
    public List<Cart> getCartDetails() {
        return cartRepo.findAll();
    }

    //ADDING A NEW CART
    public Cart postCartDetails(Cart cart) {
        return cartRepo.save(cart);
    }

    //GETTING A SPECIFIC CART BY USER ID (MAPPING BETWEEN USER AND CART)
    public Cart getSpecificCart(int id) {
        return cartRepo.findCartByUserId(id);
    }

    //UPDATING THE PRODUCT DETAILS OF A CART
    public Cart putCartDetails(Products products, int cart_id, int quantity) {
        Cart cart = cartRepo.findById(cart_id);
        for (Products P : cart.getProductList()) {
            if (P.getProductId() == products.getProductId()) {
                int newQuantity = P.getQuantity() + quantity;
                P.setQuantity(newQuantity);
                return cartRepo.save(cart);
            }
        }
        products.setQuantity(quantity);
        cart.getProductList().add(products);
        return cartRepo.save(cart);
    }

    //EMPTYING THE CART WITHOUT DELETING IT
    public Cart putCartDetails(Products product, int cart_id) {
        Cart cart = cartRepo.findById(cart_id);
        cart.getProductList().remove(product);
        return cartRepo.save(cart);
    }

    //DELETING THE CART
    public Cart removeUserCart(int id){

        Cart cart = cartRepo.findById(id);
        cart.setProductList(null);
        
        return cartRepo.findById(id);   
    }


}
