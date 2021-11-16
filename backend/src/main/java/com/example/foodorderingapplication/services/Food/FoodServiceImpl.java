package com.example.foodorderingapplication.services.Food;

import com.example.foodorderingapplication.db.entities.Food;
import com.example.foodorderingapplication.db.entities.Restaurant;
import com.example.foodorderingapplication.db.repository.FoodRepository;
import com.example.foodorderingapplication.db.repository.RestaurantRepository;
import com.example.foodorderingapplication.dto.FoodDetails;
import com.example.foodorderingapplication.dto.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<FoodDto> getAllFoodByRestaurant(Long id) {
        return foodRepository.findByRestaurantId(id);
    }

    @Override
    public FoodDto createFood(Long id,FoodDetails foodDetails) {

        Food food = new Food();
        food.setDescription(foodDetails.getDescription());
        food.setPrice(foodDetails.getPrice());
        food.setName(foodDetails.getName());

        food.setRestaurant(restaurantRepository.findById(id).get());

        food = foodRepository.save(food);
        System.out.println(id);
        return new FoodDto(food.getId(),foodDetails.getName(),foodDetails.getDescription(),foodDetails.getPrice(),id);
    }

    @Override
    public FoodDto editFood(Long id,FoodDetails foodDetails) {
        return null;
    }

    @Override
    public void deleteFood() {

    }
}
