package com.example.foodorderingapplication.services.Restaurant;

import com.example.foodorderingapplication.dto.RestaurantDTO;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<RestaurantDTO> getRestaurants();
    List<RestaurantDTO> getOwnerRestaurants(Long id);
    RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO);
    RestaurantDTO editRestaurant(RestaurantDTO restaurantDTO);
    void deleteRestaurant(Long id);

}
