package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.Category;
import com.example.foodorderingapplication.db.entities.Food;
import com.example.foodorderingapplication.db.entities.Restaurant;
import com.example.foodorderingapplication.dto.food.FoodDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food,Long> {

    @Query("select new com.example.foodorderingapplication.dto.food.FoodDto(f.id,f.name,f.description,f.price,r.id,f.category) from Food f " +
            "join f.restaurant r where r.id = :id")
    List<FoodDto> findByRestaurantId(@Param("id") Long id);

    Optional<Food> findByNameAndRestaurant(String name, Restaurant restaurant);

    List<Food> findByRestaurant(Restaurant restaurant);

    @Query("select new com.example.foodorderingapplication.dto.food.FoodDto(f.id,f.name,f.description,f.price,r.id,f.category) from Food f " +
                  "join f.restaurant r where f.category = :category")
    List<FoodDto> getFoodDtoByCategory(Category category);
}
