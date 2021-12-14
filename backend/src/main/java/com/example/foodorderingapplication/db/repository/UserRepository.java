package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.User;
import com.example.foodorderingapplication.dto.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT new com.example.foodorderingapplication.dto.user.UserProfile(u.id,u.username,u.address,u.role,u.email) from User u")
    List<UserProfile> getallUserProfile();

    @Query("SELECT new com.example.foodorderingapplication.dto.user.UserProfile(u.id,u.username,u.address,u.role,u.email) from User u where u.id = :id ")
    Optional<UserProfile> getUserProfile(@Param("id") Long id);

    User findByEmail(String email);
    User findByUsername(String username);

}
