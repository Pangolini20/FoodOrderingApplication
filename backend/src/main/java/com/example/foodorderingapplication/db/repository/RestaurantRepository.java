package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.Restaurant;
import com.example.foodorderingapplication.dto.RestaurantDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    @Query("select new com.example.foodorderingapplication.dto.RestaurantDTO(r.id,r.name,u.id) from Restaurant r join r.owner u")
    List<RestaurantDTO> findAllRestaurants();

    @Query("select new com.example.foodorderingapplication.dto.RestaurantDTO(r.id,r.name,u.id) from Restaurant r join r.owner u where u.id= :id")
    List<RestaurantDTO> findAllRestaurants(@Param("id") Long id);
}
