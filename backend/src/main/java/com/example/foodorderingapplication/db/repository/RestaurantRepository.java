package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.Restaurant;
import com.example.foodorderingapplication.dto.RestaurantDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    @Query("select new com.example.foodorderingapplication.dto.RestaurantDTO(r.id,r.name) from Restaurant r")
    List<RestaurantDTO> findAllRestaurants();
}
