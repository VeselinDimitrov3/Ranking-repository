package com.example.Data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLIntegrityConstraintViolationException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClubDoublingException extends SQLIntegrityConstraintViolationException {

    public ClubDoublingException(String ex) {
        super(ex);
    }
}
