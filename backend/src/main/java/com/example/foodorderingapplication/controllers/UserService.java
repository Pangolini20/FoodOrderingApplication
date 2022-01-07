package com.example.foodorderingapplication.controllers;


import com.example.foodorderingapplication.db.entities.User;
import com.example.foodorderingapplication.dto.restaurant.RegisterDetails;
import com.example.foodorderingapplication.dto.user.UserLoginCredentials;
import com.example.foodorderingapplication.dto.user.UserProfile;
import com.example.foodorderingapplication.exceptions.CannotCreateUserException;
import com.example.foodorderingapplication.exceptions.NoDataFoundException;
import com.example.foodorderingapplication.exceptions.UserNotFoundException;
import com.example.foodorderingapplication.services.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:8080")
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

    @Override
    @PutMapping("/edit")
    public ResponseEntity<UserProfile> editUser(@RequestBody UserProfile userProfile) {
        User user = userService.editUser(userProfile);
        if(user != null)
        {
            UserProfile userProfile1=new UserProfile(user.getId(),
                    user.getUsername(),
                    user.getAddress(),
                    user.getRole(),
                    user.getEmail());

            ResponseEntity<UserProfile> entity = new ResponseEntity<UserProfile>(userProfile1,HttpStatus.OK);
            return entity;

        }
        else throw new UserNotFoundException();


    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<UserLoginCredentials> login(@RequestBody UserLoginCredentials userLoginCredentials)
    {
        if(userService.loginCheck(userLoginCredentials) == Boolean.TRUE)
        {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
