package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
