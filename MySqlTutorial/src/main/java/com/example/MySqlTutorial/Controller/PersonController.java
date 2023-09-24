package com.example.MySqlTutorial.Controller;

import com.example.MySqlTutorial.Model.Person;
import com.example.MySqlTutorial.request.CreatePersonRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    /*
    @PostMapping("/person")
    public void createPerson(@RequestBody Person person){

    }
     */
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @PostMapping("/person")
    public Person createPerson(@RequestBody @Valid CreatePersonRequest personRequest){
        logger.info("person - {}", personRequest);
        MultiValueMap<String, String>headers = new HttpHeaders();
        headers.add("sample header", "Person Type Object");
        return new ResponseEntity<>(new Person(), headers, HttpStatus.CREATED).getBody();
       // return new ResponseEntity<>(new Person(), HttpStatus.CREATED).getBody();
    }
}
