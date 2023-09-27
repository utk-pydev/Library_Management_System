package com.example.MySqlTutorial.Exceptions;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(String message){
        super(message);
    }
}
