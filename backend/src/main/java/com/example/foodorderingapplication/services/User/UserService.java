package com.example.foodorderingapplication.services.User;


import com.example.foodorderingapplication.dto.UserProfile;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserProfile> getUsers();
    Optional<UserProfile> getUser(Long id);
}
