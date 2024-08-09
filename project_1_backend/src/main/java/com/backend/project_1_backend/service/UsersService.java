package com.backend.project_1_backend.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.project_1_backend.model.Cart;
import com.backend.project_1_backend.model.Users;
import com.backend.project_1_backend.repository.UsersRepo;

@Service
public class UsersService {

    @Autowired
    UsersRepo usersRepo;

    public Users postUserDetails(Users u){
        u.setAssignedCart(new Cart());
        return usersRepo.save(u);
    }

    public List<Users> getUserDetails(){
        return usersRepo.findAll();
    }

    public Users getSingleUser(int id){
        return usersRepo.findById(id);
    }

    public Users removeUserCart(int id){

        Users users = usersRepo.findById(id);
        users.getAssignedCart().getProductList().clear();
        return usersRepo.save(users);
        //return usersRepo.findById(id);
    }


}
