package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
