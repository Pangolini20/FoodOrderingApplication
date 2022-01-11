package com.example.foodorderingapplication.dto.food;

import com.example.foodorderingapplication.db.entities.Category;

public class FoodDto {

    private Long id;
    private String name;
    private String description;
    private Long price;
    private Long restaurantId;
    private Category category;

    public FoodDto() {
    }

    @Override
    public String toString() {
        return "FoodDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", restaurantId=" + restaurantId +
                ", category=" + category +
                '}';
    }

    public FoodDto(Long id, String name, String description, Long price, Long restaurantId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public FoodDto(Long id, String name, String description, Long price, Long restaurantId, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurantId = restaurantId;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
