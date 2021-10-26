package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<Code,Long> {
}
