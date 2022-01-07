package com.example.foodorderingapplication.services.Food;

import com.example.foodorderingapplication.db.entities.Category;
import com.example.foodorderingapplication.db.entities.Food;
import com.example.foodorderingapplication.db.repository.FoodRepository;
import com.example.foodorderingapplication.db.repository.RestaurantRepository;
import com.example.foodorderingapplication.dto.food.FoodDetails;
import com.example.foodorderingapplication.dto.food.FoodDto;
import com.example.foodorderingapplication.exceptions.NameAlreadyExistsException;
import com.example.foodorderingapplication.exceptions.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    Boolean checkName(Long id,String name)
    {
        Long c = getNrOfWordApparitions(id, name);
        if (c == null) return true;

        if(c>=1)
            return false;

        return true;
    }

    Boolean checkNameEdit(Long id,String name){
        Optional<Food> foodOptional= foodRepository.findById(id);

        if(foodOptional.isEmpty())
        {
            throw new NoDataFoundException();
        }

        Food new_f = foodOptional.get();
        List<Food> foodList=foodRepository.findByRestaurant(new_f.getRestaurant());

        for(Food f : foodList)
        {
            if(f.getName().equals(name) && f.getId() !=id)
            {
                return false;
            }
        }

        return true;
    }

    private Long getNrOfWordApparitions(Long id, String name) {
        List<FoodDto> foodList=foodRepository.findByRestaurantId(id);
        if(foodList.isEmpty())
            return null;

        List<String> nameList= foodList.stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());

        long c=nameList.stream()
                .filter(x -> x.equals(name))
                .count();
        return c;
    }

    @Override
    public FoodDto createFood(Long id,FoodDetails foodDetails) {

        if(!checkName(id,foodDetails.getName()))
        {
            throw new NameAlreadyExistsException();
        }

        Food food = new Food();
        food.setDescription(foodDetails.getDescription());
        food.setPrice(foodDetails.getPrice());
        food.setName(foodDetails.getName());
        food.setCategory(foodDetails.getCategory());

        food.setRestaurant(restaurantRepository.findById(id).get());

        food = foodRepository.save(food);
        System.out.println(id);
        return new FoodDto(food.getId(),foodDetails.getName(),foodDetails.getDescription(),foodDetails.getPrice(),id,food.getCategory());
    }

    @Override
    public FoodDto editFood(Long id,FoodDetails foodDetails) {

        Optional<Food> opt = foodRepository.findById(id);
        if(opt.isEmpty())
            throw new NoDataFoundException();

        if(!checkNameEdit(id,foodDetails.getName()))
        {
            throw new NameAlreadyExistsException();
        }

        Food food=opt.get();
        food.setName(foodDetails.getName());
        food.setDescription(foodDetails.getDescription());
        food.setPrice(foodDetails.getPrice());
        food.setCategory(foodDetails.getCategory());

        foodRepository.save(food);

        return new FoodDto(id,foodDetails.getName(),foodDetails.getDescription(),foodDetails.getPrice(),food.getRestaurant().getId(),food.getCategory());
    }

    @Override
    public void deleteFood(Long id) {
        Optional<Food> food = foodRepository.findById(id);
        if(food.isEmpty())
            throw new NoDataFoundException();
        foodRepository.delete(food.get());
    }

    @Override
    public List<FoodDto> getFoodByCategory(Category category) {
        return foodRepository.getFoodDtoByCategory(category);
    }
}
