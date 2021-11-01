package com.example.foodorderingapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "the email is already used")
public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException() {
        super();
    }
}
