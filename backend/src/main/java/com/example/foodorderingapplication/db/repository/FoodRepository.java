package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {

}
