package com.example.foodorderingapplication.db.entities;

import javax.persistence.*;

@Entity
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long value;
    private String expirationDate;

    @ManyToOne
    private Restaurant restaurant;

    public Code() {
    }

    public Code(Long id, String name, Long value, String expirationDate, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.expirationDate = expirationDate;
        this.restaurant = restaurant;
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
