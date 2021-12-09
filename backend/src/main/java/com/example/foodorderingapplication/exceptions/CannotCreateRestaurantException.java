package com.example.foodorderingapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "cannot create restaurant")
public class CannotCreateRestaurantException extends RuntimeException{

    public CannotCreateRestaurantException(String message) {
        super(message);
    }
}
