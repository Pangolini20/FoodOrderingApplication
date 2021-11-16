package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.Food;
import com.example.foodorderingapplication.dto.FoodDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {

    @Query("select new com.example.foodorderingapplication.dto.FoodDto(f.id,f.name,f.description,f.price,r.id) from Food f " +
            "join f.restaurant r where r.id = :id")
    List<FoodDto> findByRestaurantId(@Param("id") Long id);

}
