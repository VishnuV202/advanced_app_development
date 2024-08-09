package com.backend.project_1_backend.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project_1_backend.model.Cart;
import com.backend.project_1_backend.model.Products;
import com.backend.project_1_backend.service.CartService;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    //GET DETAILS OF ALL THE CARTS
    @GetMapping("/Cart")
    public List<Cart> getCartItems()
    {
        return cartService.getCartDetails();
    }

    //GET DETAILS OF A SPECIFIC CART BY USER ID
    @GetMapping("/Cart/{user_id}")
    public Cart getSingleCart(@PathVariable int user_id)
    {
        return cartService.getSpecificCart(user_id);
    }

    //ADDING A NEW CART
    @PostMapping("/Cart")
    public Cart postCartDetail(@RequestBody Cart cart)
    {
        return cartService.postCartDetails(cart);
    }

    //UPDATING THE DETAILS OF A SPECIFIC CART
    @PutMapping("/Cart/put/{cart_id}/{quantity}")
    public Cart putCartDetail(@RequestBody Products products, @PathVariable int cart_id,@PathVariable int quantity)
    {
        return cartService.putCartDetails(products, cart_id, quantity);
    }

    //EMPTYING THE EXISITING CART WITHOUT DELETING
    @PutMapping("/Cart/{product}/{cart_id}")
    public Cart removeProduct(@RequestBody Products products, @PathVariable Products product,@PathVariable int cart_id)
    {
        return cartService.putCartDetails(product, cart_id);
    }

    //DELETING THE ENTIRE CART
    @DeleteMapping("/Cart/deleteData/{id}")
    public Cart deleteUser(@PathVariable int id)
    {
        return cartService.removeUserCart(id);
    }
}

