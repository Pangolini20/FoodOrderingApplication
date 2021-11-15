package com.example.foodorderingapplication.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "restaurant")
    private List<Food> foodList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "restaurant")
    private List<Code> codeList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "restaurant")
    private List<Order> orderList;

    @ManyToOne
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "restaurant_delivery",
            joinColumns = @JoinColumn(name = "restaurantId"),
            inverseJoinColumns = @JoinColumn(name ="userId")
    )
    private List<User> deliveryWorker;

    public Restaurant() {
    }

    public Restaurant(Long id, String name, List<Food> foodList, List<Code> codeList, List<Order> orderList, User owner, List<User> deliveryWorker) {
        this.id = id;
        this.name = name;
        this.foodList = foodList;
        this.codeList = codeList;
        this.orderList = orderList;
        this.owner = owner;
        this.deliveryWorker = deliveryWorker;
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

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List<Code> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<Code> codeList) {
        this.codeList = codeList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getDeliveryWorker() {
        return deliveryWorker;
    }

    public void setDeliveryWorker(List<User> deliveryWorker) {
        this.deliveryWorker = deliveryWorker;
    }
}
