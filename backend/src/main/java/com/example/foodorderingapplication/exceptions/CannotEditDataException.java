package com.example.foodorderingapplication.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "could not edit the restaurant details")
public class CannotEditDataException extends RuntimeException{

    public CannotEditDataException() {
        super();
    }
}
