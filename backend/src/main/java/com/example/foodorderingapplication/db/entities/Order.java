package com.example.foodorderingapplication.db.entities;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Order() {
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_food",
    joinColumns = @JoinColumn(name = "orderId"),
    inverseJoinColumns = @JoinColumn(name = "foodId"))
    private List<Food> foodList;

    @ManyToOne
    private User deliveryGuy;

    @ManyToOne
    private User receiver;

    @ManyToOne
    private Restaurant restaurant;

    private String time;

    public Order(Long id, List<Food> foodList, User deliveryGuy, User receiver, Restaurant restaurant, String time) {
        this.id = id;
        this.foodList = foodList;
        this.deliveryGuy = deliveryGuy;
        this.receiver = receiver;
        this.restaurant = restaurant;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public User getDeliveryGuy() {
        return deliveryGuy;
    }

    public void setDeliveryGuy(User deliveryGuy) {
        this.deliveryGuy = deliveryGuy;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

