package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.dto.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserController {


    List<UserProfile> getAllUsers();
    Optional<UserProfile> getUser(Long id);
}
