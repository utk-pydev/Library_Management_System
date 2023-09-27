package com.example.MySqlTutorial;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Configuration
public class HandlerConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public int handleMethodArgumentNotValidException(){
        return 1;
    }
}
