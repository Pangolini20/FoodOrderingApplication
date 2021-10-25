package com.example.foodorderingapplication.db.entities;

import javax.persistence.*;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Integer price;

    @ManyToOne
    private Restaurant restaurant;

}
