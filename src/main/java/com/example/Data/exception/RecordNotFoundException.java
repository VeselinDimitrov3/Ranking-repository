package com.example.Data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecordNotFoundException extends NoSuchElementException {
    public RecordNotFoundException (String message) {
        super(message);
    }
}
