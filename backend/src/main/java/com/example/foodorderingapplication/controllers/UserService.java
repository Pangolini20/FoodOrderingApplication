package com.example.foodorderingapplication.controllers;


import com.example.foodorderingapplication.services.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserService {

    @Autowired
    UserServiceImpl userService;






}
