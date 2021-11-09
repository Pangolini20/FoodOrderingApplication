package com.example.foodorderingapplication.services.Restaurant;

import com.example.foodorderingapplication.db.repository.RestaurantRepository;
import com.example.foodorderingapplication.dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantServiceImpl implements  RestaurantService{

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDTO> getRestaurants() {
        return restaurantRepository.findAllRestaurants();
    }




}
