package com.example.foodorderingapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "username already exists")
public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String msg) {
        super(msg);
    }
}
