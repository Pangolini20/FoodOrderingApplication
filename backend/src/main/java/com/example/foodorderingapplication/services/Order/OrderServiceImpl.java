package com.example.foodorderingapplication.services.Order;

import com.example.foodorderingapplication.db.entities.Food;
import com.example.foodorderingapplication.db.entities.Order;
import com.example.foodorderingapplication.db.entities.Restaurant;
import com.example.foodorderingapplication.db.entities.User;
import com.example.foodorderingapplication.db.repository.FoodRepository;
import com.example.foodorderingapplication.db.repository.OrderRepository;
import com.example.foodorderingapplication.db.repository.RestaurantRepository;
import com.example.foodorderingapplication.db.repository.UserRepository;
import com.example.foodorderingapplication.dto.food.FoodDto;
import com.example.foodorderingapplication.dto.order.OrderDto;
import com.example.foodorderingapplication.exceptions.NoDataFoundException;
import com.example.foodorderingapplication.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    FoodRepository foodRepository;

    @Override
    public List<OrderDto> getOrders(Long id) {
        List<OrderDto> orders= orderRepository.getOrdersByUserId(id);
        for(OrderDto orderDto : orders)
        {
            List<FoodDto> foodDtoList= foodRepository.getFoodByOrder(orderDto.getId());
            orderDto.setFoodDtoList(foodDtoList);
        }

        return orders;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        Order order = new Order();

        Optional<User> deliveryopt = userRepository.findById(orderDto.getDeliveryUserId());
        if(deliveryopt.isEmpty())
        {
            throw new UserNotFoundException();
        }

        Optional<User> receieveropt = userRepository.findById(orderDto.getReceiverId());
        if(receieveropt.isEmpty())
        {
            throw new UserNotFoundException();
        }

        Optional<Restaurant> restOpt = restaurantRepository.findById(orderDto.getRestaurantId());
        if(restOpt.isEmpty())
        {
            throw new NoDataFoundException();
        }


        List<FoodDto> foodDtoList=orderDto.getFoodDtoList();
        List<Food> foodList = DtoToFood(foodDtoList);

        order.setDeliveryGuy(deliveryopt.get());
        order.setRestaurant(restOpt.get());
        order.setReceiver(receieveropt.get());
        order.setTime(orderDto.getDate());
        order.setFoodList(foodList);

        orderRepository.save(order);
        return orderDto;
    }

    private List<Food> DtoToFood(List<FoodDto> foodDtoList)
    {
        List<Food> foodList = new ArrayList(Arrays.asList());
        for(FoodDto dto : foodDtoList )
        {

            Food food = getFood(dto);
            foodList.add(food);
        }
        return foodList;
    }

    private Food getFood(FoodDto dto) {
        System.out.println(dto.toString());


        if(foodRepository.findById(dto.getId()).isEmpty())
            throw new NoDataFoundException();

        Food food = new Food();
        food.setCategory(dto.getCategory());
        food.setName(dto.getName());
        food.setDescription(dto.getDescription());

        Optional<Restaurant> opt =restaurantRepository.findById(dto.getRestaurantId());

        if(opt.isEmpty())
            throw new NoDataFoundException();

        food.setRestaurant(opt.get());
        food.setPrice(dto.getPrice());
        return food;
    }

}
