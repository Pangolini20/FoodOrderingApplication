package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
