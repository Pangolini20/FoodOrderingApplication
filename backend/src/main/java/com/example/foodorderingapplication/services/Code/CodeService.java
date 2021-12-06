package com.example.foodorderingapplication.services.Code;

import com.example.foodorderingapplication.dto.CodeDto;

import java.util.List;

public interface CodeService {
    List<CodeDto> getRestaurantCodes(Long id);
}
