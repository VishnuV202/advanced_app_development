package com.backend.project_1_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project_1_backend.model.Users;
import com.backend.project_1_backend.service.UsersService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    //ADD A USER
    @PostMapping("/UserData")
    public Users addUsers  (@RequestBody Users u){
        return usersService.postUserDetails(u);
    }

    //GET ALL USERS
    @GetMapping("/UserData")
    public List<Users> getUsers(){
        return usersService.getUserDetails();
    }

    //GET DETAILS OF A USER BY USER ID
    @GetMapping("/UserData/{id}")
    public Users getSingleUser(@PathVariable Integer id){
        return usersService.getSingleUser(id);
    }

    //DELETE A USER
    @DeleteMapping("/UserData/deleteData/{id}")
    public Users deleteUser(@PathVariable int id)
    {
        return usersService.removeUserCart(id);
    }

}
