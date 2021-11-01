package com.example.foodorderingapplication.controllers;


import com.example.foodorderingapplication.db.entities.Role;
import com.example.foodorderingapplication.db.entities.User;
import com.example.foodorderingapplication.dto.RegisterDetails;
import com.example.foodorderingapplication.dto.UserProfile;
import com.example.foodorderingapplication.exceptions.CannotCreateUserException;
import com.example.foodorderingapplication.exceptions.NoDataFoundException;
import com.example.foodorderingapplication.exceptions.UserNotFoundException;
import com.example.foodorderingapplication.services.User.UserServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserService implements UserController{

    @Autowired
    UserServiceImpl userService;

    @Override
    @GetMapping()
    public List<UserProfile> getAllUsers() {
        List<UserProfile> userProfileList=userService.getUsers();
        if(userProfileList.isEmpty())
            throw  new NoDataFoundException();

        return userProfileList;
    }

    @Override
    @GetMapping("/{id}")
    public Optional<UserProfile> getUser(@RequestParam Long id) {
        Optional<UserProfile> opt = userService.getUser(id);
        if(opt.isPresent())
            return opt;
        else
            throw new UserNotFoundException();
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody RegisterDetails registerDetails) {

        User u = userService.createUser(registerDetails);

        if (u != null)
        {
            ResponseEntity<User> entity = new ResponseEntity<User>(u,HttpStatus.CREATED);
            return entity;
        }
        else throw new CannotCreateUserException();

    }




}
