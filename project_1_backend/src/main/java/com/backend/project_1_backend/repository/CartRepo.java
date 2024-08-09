package com.backend.project_1_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.project_1_backend.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer>{

    @Query(nativeQuery = true,value = "SELECT c.* from Users u left join Cart c on u.cart_id = c.cart_id where u.id = ?1;")
    public Cart findCartByUserId(int user_id);

    Cart findById(int id);

}
