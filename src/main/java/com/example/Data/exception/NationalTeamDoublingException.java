package com.example.Data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLIntegrityConstraintViolationException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NationalTeamDoublingException extends SQLIntegrityConstraintViolationException {

    public NationalTeamDoublingException (String ex) {
        super(ex);
    }
}
