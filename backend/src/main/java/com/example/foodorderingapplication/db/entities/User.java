package com.example.foodorderingapplication.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String passwordHash;
    private Role role;
    private String address;
    private String email;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "deliveryGuy")
    private List<Order> tasks;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "receiver")
    private List<Order> orders;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "payer")
    private List<Transaction> transactions;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "owner")
    private List<Restaurant> ownedRestaurants;

    @ManyToMany(mappedBy = "deliveryWorker") // the restaurant you work on
    private List<Restaurant> restaurantList;

    public User(Long id, String username, String passwordHash, Role role, String address, String email, List<Order> tasks, List<Order> orders, List<Transaction> transactions, List<Restaurant> ownedRestaurants) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
        this.address = address;
        this.email = email;
        this.tasks = tasks;
        this.orders = orders;
        this.transactions = transactions;
        this.ownedRestaurants = ownedRestaurants;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getTasks() {
        return tasks;
    }

    public void setTasks(List<Order> tasks) {
        this.tasks = tasks;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Restaurant> getOwnedRestaurants() {
        return ownedRestaurants;
    }

    public void setOwnedRestaurants(List<Restaurant> ownedRestaurants) {
        this.ownedRestaurants = ownedRestaurants;
    }

    public void addRestaurant(Restaurant restaurant)
    {
        ownedRestaurants.add(restaurant);
    }

    public void removeRestaurant(Restaurant restaurant)
    {
        ownedRestaurants.remove(restaurant);
    }
}
