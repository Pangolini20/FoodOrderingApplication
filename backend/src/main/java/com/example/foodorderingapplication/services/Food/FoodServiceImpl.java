package com.example.foodorderingapplication.services.Food;

import com.example.foodorderingapplication.db.entities.Food;
import com.example.foodorderingapplication.db.entities.Restaurant;
import com.example.foodorderingapplication.db.repository.FoodRepository;
import com.example.foodorderingapplication.db.repository.RestaurantRepository;
import com.example.foodorderingapplication.dto.FoodDetails;
import com.example.foodorderingapplication.dto.FoodDto;
import com.example.foodorderingapplication.exceptions.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        Optional<Food> opt = foodRepository.findById(id);
        if(opt.isEmpty())
            throw new NoDataFoundException();

        Food food=opt.get();
        food.setName(foodDetails.getName());
        food.setDescription(foodDetails.getDescription());
        food.setPrice(foodDetails.getPrice());

        foodRepository.save(food);

        return new FoodDto(id,foodDetails.getName(),foodDetails.getDescription(),foodDetails.getPrice(),food.getRestaurant().getId());
    }

    @Override
    public void deleteFood(Long id) {
        Optional<Food> food = foodRepository.findById(id);
        if(food.isEmpty())
            throw new NoDataFoundException();
        foodRepository.delete(food.get());
    }
}
