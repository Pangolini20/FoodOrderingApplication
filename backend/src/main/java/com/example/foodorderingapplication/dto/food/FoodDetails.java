package com.example.foodorderingapplication.dto;

import com.example.foodorderingapplication.db.entities.Category;

public class FoodDetails {
    private String name;
    private String description;
    private Long price;
    private Category category;

    public FoodDetails() {
    }

    public FoodDetails(String name, String description, Long price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public FoodDetails(String name, String description, Long price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Category getCategory() {

        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
}
