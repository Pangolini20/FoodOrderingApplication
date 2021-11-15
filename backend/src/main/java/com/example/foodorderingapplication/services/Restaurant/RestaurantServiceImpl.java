package com.example.foodorderingapplication.services.Restaurant;

import com.example.foodorderingapplication.db.entities.Restaurant;
import com.example.foodorderingapplication.db.entities.User;
import com.example.foodorderingapplication.db.repository.RestaurantRepository;
import com.example.foodorderingapplication.db.repository.UserRepository;
import com.example.foodorderingapplication.dto.RestaurantDTO;
import com.example.foodorderingapplication.exceptions.CannotCreateRestaurantException;
import com.example.foodorderingapplication.exceptions.NoDataFoundException;
import com.example.foodorderingapplication.exceptions.RestaurantNotFoundException;
import com.example.foodorderingapplication.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements  RestaurantService{

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<RestaurantDTO> getRestaurants() {
        return restaurantRepository.findAllRestaurants();
    }

    @Override
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {


        Optional<User> userOptional= userRepository.findById(restaurantDTO.getOwnerId());
        if(userOptional.isPresent())
        {
            Restaurant restaurant = new Restaurant();
            restaurant.setName(restaurantDTO.getName());
            restaurant.setOwner(userOptional.get());
            restaurant.setCodeList(Collections.emptyList());
            restaurant.setDeliveryWorker(Collections.emptyList());
            restaurant.setFoodList(Collections.emptyList());

            restaurant=restaurantRepository.save(restaurant);
            if(restaurant == null)
            {
                throw new CannotCreateRestaurantException("Couldn' t create restaurant");
            }

            restaurantDTO.setId(restaurant.getId());
        }
        else
            throw new UserNotFoundException();

        return restaurantDTO;

    }

    @Override
    public List<RestaurantDTO> getOwnerRestaurants(Long id) {
        List<RestaurantDTO> restaurantDTOList = restaurantRepository.findAllRestaurants(id);

        if(restaurantDTOList.isEmpty())
            throw new NoDataFoundException();

        return restaurantDTOList;
    }

    @Override
    public RestaurantDTO editRestaurant(RestaurantDTO restaurantDTO) {

        Restaurant restaurant= restaurantRepository.getById(restaurantDTO.getId());

        if(restaurant ==null)
        {
            throw new RestaurantNotFoundException("restaurant not found");
        }
        else
        {
            restaurant.setName(restaurantDTO.getName());
            restaurantRepository.save(restaurant);
        }

        return restaurantDTO;
    }

    @Override
    public void deleteRestaurant(Long id) {
        Restaurant restaurant= restaurantRepository.getById(id);
        if(restaurant ==null) {
            throw new RestaurantNotFoundException("restaurant not found");
        }
        restaurantRepository.delete(restaurant);
    }
}
