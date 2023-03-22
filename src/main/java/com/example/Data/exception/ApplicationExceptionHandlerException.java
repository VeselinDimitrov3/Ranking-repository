package com.example.Data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandlerException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String, String> handleMethodArgNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> handledErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            handledErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return handledErrors;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClubDoublingException.class)
    String handleEmailDoublingException(ClubDoublingException ex) {
        return "Club already exists!";
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NationalTeamDoublingException.class)
    String handlePhoneNumberDoublingException(NationalTeamDoublingException ex) {
        return "National team already exists!";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RecordNotFoundException.class)
    String handlerRecordNotFoundException(RecordNotFoundException ex) {
        return ex.getMessage();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClubNotFoundException.class)
    String handlerCarNotFoundException(ClubNotFoundException ex) {
        return ex.getMessage();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NationalTeamNotFoundException.class)
    String handlerReservationNotFoundException(NationalTeamNotFoundException ex) {
        return ex.getMessage();
    }

}
