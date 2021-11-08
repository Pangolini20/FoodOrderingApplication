package com.example.foodorderingapplication.services.User;


import com.example.foodorderingapplication.db.entities.User;
import com.example.foodorderingapplication.dto.RegisterDetails;
import com.example.foodorderingapplication.dto.UserLoginCredentials;
import com.example.foodorderingapplication.dto.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserProfile> getUsers();
    Optional<UserProfile> getUser(Long id);
    User createUser(RegisterDetails registerDetails);
    User editUser(UserProfile userProfile);
    Boolean loginCheck(UserLoginCredentials userLoginCredentials);
}
