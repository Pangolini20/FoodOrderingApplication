package com.example.foodorderingapplication.db.entities;

import javax.persistence.*;

@Entity
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer value;
    private String expirationDate;

    @ManyToOne
    private Restaurant restaurant;

}
