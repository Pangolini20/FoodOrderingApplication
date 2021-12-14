package com.example.foodorderingapplication.services.Restaurant;

import com.example.foodorderingapplication.db.entities.Restaurant;
import com.example.foodorderingapplication.db.entities.User;
import com.example.foodorderingapplication.db.repository.RestaurantRepository;
import com.example.foodorderingapplication.db.repository.UserRepository;
import com.example.foodorderingapplication.dto.restaurant.RestaurantDTO;
import com.example.foodorderingapplication.exceptions.*;
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

        Optional<User> userOptional = userRepository.findById(restaurantDTO.getOwnerId());
        if(userOptional.isEmpty())
        {
            throw new UserNotFoundException();
        }

        Optional<Restaurant> opt= restaurantRepository.findById(restaurantDTO.getId());

        if(opt.isPresent())
        {
            Restaurant r=opt.get();
            r.setName(restaurantDTO.getName());
            restaurantRepository.save(r);

            return restaurantDTO;
        }
        else
            throw new NoDataFoundException();

    }

    @Override
    public void deleteRestaurant(Long id) {
        Optional<Restaurant> restaurantOptional= restaurantRepository.findById(id);
        if(restaurantOptional.isEmpty()) {
            throw new RestaurantNotFoundException("restaurant not found");
        }
        else
            restaurantRepository.delete(restaurantOptional.get());
    }
}
