package com.example.MySqlTutorial.Service;

import com.example.MySqlTutorial.Exceptions.PersonNotFoundException;
import com.example.MySqlTutorial.Model.Person;
import com.example.MySqlTutorial.Repository.PersonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonInterface personInterface;

    public Person getPerson(int idx) throws PersonNotFoundException {
        return personInterface.findById(idx).orElseThrow(()->new PersonNotFoundException("Id not found"));
    }
}
