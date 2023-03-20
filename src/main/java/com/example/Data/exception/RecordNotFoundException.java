package com.example.Data.exception;

import java.util.NoSuchElementException;

public class RecordNotFoundException extends NoSuchElementException {
    public RecordNotFoundException (String message) {
        super(message);
    }
}
