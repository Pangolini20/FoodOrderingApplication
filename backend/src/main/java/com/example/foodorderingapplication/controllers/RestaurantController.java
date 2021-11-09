package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantController {

    List<RestaurantDTO> getRestaurants();
}
