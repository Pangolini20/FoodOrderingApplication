package com.example.foodorderingapplication.db.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {

    @Id
    private Long processorId;

    private Boolean status;



}
