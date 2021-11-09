package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.dto.RestaurantDTO;
import com.example.foodorderingapplication.services.Restaurant.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantService implements RestaurantController{

    @Autowired
    RestaurantServiceImpl restaurantService;

    @Override
    @GetMapping()
    public List<RestaurantDTO> getRestaurants() {
        return restaurantService.getRestaurants();
    }
}
