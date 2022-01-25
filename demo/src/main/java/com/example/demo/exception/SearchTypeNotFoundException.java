package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "no such search type")
public class SearchTypeNotFoundException extends Exception{

    public SearchTypeNotFoundException(String message) {
        super(message);
    }

}
