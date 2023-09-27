package com.example.MySqlTutorial.Config;

import com.example.MySqlTutorial.Exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleConfig {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity handlePersonNotFoundException(PersonNotFoundException ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
