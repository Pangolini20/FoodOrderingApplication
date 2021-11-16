package com.example.foodorderingapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Name already exists :D")
public class NameAlreadyExistsException extends RuntimeException{

    public NameAlreadyExistsException() {
        super();
    }
}
