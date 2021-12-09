package com.example.foodorderingapplication.dto;

public class CodeDto {
    private Long id;
    private Long restaurantId;
    private String name;
    private Long value;
    private String expirationDate;

    public CodeDto() {
    }

    public CodeDto(Long id) {
        this.id = id;
    }

    public CodeDto(Long id, Long restaurantId, String name, Long value, String expirationDate) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.name = name;
        this.value = value;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
