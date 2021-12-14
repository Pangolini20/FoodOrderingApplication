package com.example.foodorderingapplication.services.User;


import com.example.foodorderingapplication.db.entities.User;
import com.example.foodorderingapplication.dto.restaurant.RegisterDetails;
import com.example.foodorderingapplication.dto.user.UserLoginCredentials;
import com.example.foodorderingapplication.dto.user.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserProfile> getUsers();
    Optional<UserProfile> getUser(Long id);
    User createUser(RegisterDetails registerDetails);
    User editUser(UserProfile userProfile);
    Boolean loginCheck(UserLoginCredentials userLoginCredentials);
}
