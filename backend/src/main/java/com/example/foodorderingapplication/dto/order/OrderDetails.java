package com.example.foodorderingapplication.dto.order;

import com.example.foodorderingapplication.dto.food.FoodDto;

import java.util.List;

public class OrderDetails {
    private String deliveredBy;
    private String restaurantName;
    private String date;
    private List<FoodDto> foodDtoList;

    public OrderDetails(String deliveredBy, String restraurantName, String date, List<FoodDto> foodDtoList) {
        this.deliveredBy = deliveredBy;
        this.restaurantName = restraurantName;
        this.date = date;
        this.foodDtoList = foodDtoList;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(String deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public String getRestraurantName() {
        return restaurantName;
    }

    public void setRestraurantName(String restraurantName) {
        this.restaurantName = restraurantName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<FoodDto> getFoodDtoList() {
        return foodDtoList;
    }

    public void setFoodDtoList(List<FoodDto> foodDtoList) {
        this.foodDtoList = foodDtoList;
    }
}
