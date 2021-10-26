package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
