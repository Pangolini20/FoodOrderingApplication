package com.example.foodorderingapplication.dto.order;

import com.example.foodorderingapplication.dto.food.FoodDto;

import java.util.List;

public class OrderDto {
    private Long id;
    private Long receiverId;
    private Long deliveryUserId;
    private Long restaurantId;
    private String date;
    private List<FoodDto> foodDtoList;

    public OrderDto(Long id, Long receiverId, Long deliveryUserId, Long restaurantId, String date) {
        this.id = id;
        this.receiverId = receiverId;
        this.deliveryUserId = deliveryUserId;
        this.restaurantId = restaurantId;
        this.date = date;
    }

    public OrderDto(Long id, Long receiverId, Long deliveryUserId, Long restaurantId, String date, List<FoodDto> foodDtoList) {
        this.id = id;
        this.receiverId = receiverId;
        this.deliveryUserId = deliveryUserId;
        this.restaurantId = restaurantId;
        this.date = date;
        this.foodDtoList = foodDtoList;
    }

    public List<FoodDto> getFoodDtoList() {
        return foodDtoList;
    }

    public void setFoodDtoList(List<FoodDto> foodDtoList) {
        this.foodDtoList = foodDtoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(Long deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
