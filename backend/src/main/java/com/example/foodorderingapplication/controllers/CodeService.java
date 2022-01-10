package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.dto.code.CodeDetails;
import com.example.foodorderingapplication.dto.code.CodeDto;
import com.example.foodorderingapplication.services.Code.CodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/code")
@CrossOrigin("http://localhost:4200")
public class CodeService implements CodeController{

    @Autowired
    public CodeServiceImpl codeService;

    @PostMapping("/{id}")
    @Override
    public ResponseEntity<CodeDto> createCode(@PathVariable(value = "id") Long id, CodeDetails codeDetails) {
        return new ResponseEntity<>(codeService.createCode(id,codeDetails),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<CodeDto> editCode(@PathVariable(value = "id") Long id, CodeDetails codeDetails) {
        return new ResponseEntity<>(codeService.editCode(id,codeDetails),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteCode(@PathVariable(value = "id") Long id) {
        codeService.deleteCode(id);
    }

    @Override
    @GetMapping("/{id}")
    public List<CodeDto> getCodesFromRestaurant(@PathVariable(value = "id") Long id) {
        return codeService.getRestaurantCodes(id);
    }

    @Override
    @GetMapping("/all")
    public List<CodeDto> getallCodes() {
        return codeService.getAllCodes();
    }
}
