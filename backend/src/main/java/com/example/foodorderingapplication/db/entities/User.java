package com.example.foodorderingapplication.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String passwordHash;
    private Role role;
    private String address;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "deliveryGuy")
    private List<Order> tasks;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "receiver")
    private List<Order> orders;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "payer")
    private List<Transaction> transactions;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "owner")
    private List<Restaurant> ownedRestaurants;



}
