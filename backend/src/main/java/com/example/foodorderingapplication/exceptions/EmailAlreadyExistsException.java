package com.example.foodorderingapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "the email is already used")
public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException(String msg) {
        super(msg);
    }
}
