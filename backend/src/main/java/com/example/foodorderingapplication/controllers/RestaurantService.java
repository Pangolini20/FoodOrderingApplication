package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.dto.restaurant.RestaurantDTO;
import com.example.foodorderingapplication.exceptions.CannotCreateRestaurantException;
import com.example.foodorderingapplication.exceptions.CannotEditDataException;
import com.example.foodorderingapplication.services.Restaurant.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin("http://localhost:4200")
public class RestaurantService implements RestaurantController{

    @Autowired
    RestaurantServiceImpl restaurantService;

    @Override
    @GetMapping()
    public List<RestaurantDTO> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @Override
    @PostMapping()
    public ResponseEntity<RestaurantDTO> createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO t=restaurantService.createRestaurant(restaurantDTO);
        if(t!=null) {
            ResponseEntity<RestaurantDTO> entity = new ResponseEntity<>(t, HttpStatus.CREATED);
            return entity;
        }
        else throw new CannotCreateRestaurantException("cannot create restaurant");
    }

    @Override
    @GetMapping("/owner/{id}")
    public List<RestaurantDTO> getRestaurantByOwner(Long id) {

        List<RestaurantDTO> restaurantDTOList = restaurantService.getOwnerRestaurants(id);

        return restaurantDTOList;
    }

    @Override
    @PutMapping("")
    public ResponseEntity<RestaurantDTO> editRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO restaurantDTO1=restaurantService.editRestaurant(restaurantDTO);

        if(restaurantDTO1 == null)
        {
            throw new CannotEditDataException();
        }

        return new ResponseEntity<RestaurantDTO>(restaurantDTO1,HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteRestaurant(Long id) {
        restaurantService.deleteRestaurant(id);
    }
}
