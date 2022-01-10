package com.example.foodorderingapplication.db.repository;

import com.example.foodorderingapplication.db.entities.Code;
import com.example.foodorderingapplication.dto.code.CodeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodeRepository extends JpaRepository<Code,Long> {

    @Query("select new com.example.foodorderingapplication.dto.code.CodeDto(c.id,r.id,c.name,c.value,c.expirationDate,r.name) from Code c join c.restaurant r where r.id = :id")
    List<CodeDto> findRestaurantCodes(@Param("id")Long id);

    @Query("select  new com.example.foodorderingapplication.dto.code.CodeDto(c.id,r.id,c.name,c.value,c.expirationDate,r.name) from Code c join c.restaurant r")
    List<CodeDto> getAllRestaurantCodes();



}
