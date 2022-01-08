package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.db.entities.Category;
import com.example.foodorderingapplication.dto.food.FoodDetails;
import com.example.foodorderingapplication.dto.food.FoodDto;
import com.example.foodorderingapplication.services.Food.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@CrossOrigin("http://localhost:4200")
public class FoodService implements FoodController{

    @Autowired
    private FoodServiceImpl foodService;

    @Override
    @GetMapping("/{id}")
    public List<FoodDto> getFoodByRestaurant(Long id) {
        return foodService.getAllFoodByRestaurant(id);
    }

    @Override
    @PostMapping("/{id}")
    public ResponseEntity<FoodDto> createFood(@PathVariable("id") Long id,@RequestBody FoodDetails foodDetails) {
        return new ResponseEntity<FoodDto>(foodService.createFood(id,foodDetails), HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<FoodDto> editFood(@PathVariable(value = "id") Long id, FoodDetails foodDetails) {
        return new ResponseEntity<FoodDto>(foodService.editFood(id,foodDetails),HttpStatus.OK);
    }

    @Override
    @DeleteMapping
    public void deleteFood(Long id) {
        foodService.deleteFood(id);
    }

    @Override
    @GetMapping("/{category}")
    public List<FoodDto> getByCategory(Category category) {
        return foodService.getFoodByCategory(category);
    }
}
