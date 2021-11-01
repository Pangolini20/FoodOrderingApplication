package com.example.foodorderingapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Could not create the new user")
public class CannotCreateUserException extends RuntimeException{
    public CannotCreateUserException() {
        super();
    }
}
