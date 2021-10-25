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

    @ManyToMany
    private List<Food> foodList;

    public Order(Long id) {
        this.id = id;
    }
}

