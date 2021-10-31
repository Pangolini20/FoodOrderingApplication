package com.example.foodorderingapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Could not find any data")
public class NoDataFoundException extends RuntimeException{

    public NoDataFoundException() {
        super();
    }
}
