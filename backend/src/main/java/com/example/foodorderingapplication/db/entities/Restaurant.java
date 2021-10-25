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
    private List<User> deliveryWorker;

}
