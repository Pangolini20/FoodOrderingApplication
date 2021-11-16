package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.dto.FoodDetails;
import com.example.foodorderingapplication.dto.FoodDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FoodController {

    List<FoodDto> getFoodByRestaurant(Long id);
    ResponseEntity<FoodDto> createFood(Long id,FoodDetails foodDetails);
    ResponseEntity<FoodDto> editFood(Long id,FoodDetails foodDetails);
    void deleteFood();
}
