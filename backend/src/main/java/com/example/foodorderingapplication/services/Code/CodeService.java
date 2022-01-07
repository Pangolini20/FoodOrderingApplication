package com.example.foodorderingapplication.services.Code;

import com.example.foodorderingapplication.dto.code.CodeDetails;
import com.example.foodorderingapplication.dto.code.CodeDto;

import java.util.List;

public interface CodeService {
    List<CodeDto> getRestaurantCodes(Long id);
    CodeDto createCode(Long id,CodeDetails codeDetails);
    CodeDto editCode(Long id,CodeDetails codeDetails);
    void deleteCode(Long id);
}
