package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.dto.RestaurantDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantController {

    List<RestaurantDTO> getRestaurants();
    ResponseEntity<RestaurantDTO> createRestaurant(RestaurantDTO restaurantDTO);
    List<RestaurantDTO> getRestaurantByOwner(Long id);
    ResponseEntity<RestaurantDTO> editRestaurant(RestaurantDTO restaurantDTO);
    void deleteRestaurant(Long id);
}
