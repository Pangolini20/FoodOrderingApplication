package com.example.foodorderingapplication.services.Food;


import com.example.foodorderingapplication.dto.FoodDetails;
import com.example.foodorderingapplication.dto.FoodDto;

import java.util.List;

public interface FoodService {

    List<FoodDto> getAllFoodByRestaurant(Long id);
    FoodDto createFood(Long id,FoodDetails foodDetails);
    FoodDto editFood(Long id,FoodDetails foodDetails);
    void deleteFood(Long id);
}
