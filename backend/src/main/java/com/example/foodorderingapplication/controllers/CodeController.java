package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.dto.CodeDetails;
import com.example.foodorderingapplication.dto.CodeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CodeController {

    ResponseEntity<CodeDto> createCode(Long id,CodeDetails codeDetails);
    ResponseEntity<CodeDto> editCode(Long id,CodeDetails codeDetails);
    void deleteCode(Long id);
    List<CodeDto> getCodesFromRestaurant(Long id);


}
