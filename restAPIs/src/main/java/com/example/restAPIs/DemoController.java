package com.example.restAPIs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
    Convert java to Json RestController on the other hand Controller doesn't do so
 */


@RequestMapping("/v2")
//Dispatcher servlets searches for RestController mapping classes.

public class DemoController {


    /// This type of dependency injection is Field based injection
    @Autowired //This annotation picks the reference of class 'Demo' from the IOC container
    Demo demo;

    //Request is managed by dispatcher servlets

    ///Here lets start with constructor based injection



    //Everytime same reference of the object will be taken from the IOC container
    //If I remove @component from

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);


    /*
    * Use autowired whenever we want to use a parameterized constructor to know spring needs to execute this constructor while initializing
    *
    * Bean - Object which is created by spring
    * Bean -  Something which will create/know during the application startup
    *
    * */
    @Autowired
    public DemoController(Demo demo){
      this.demo = demo;
        logger.info("Creating object ... {}", this);
    }

    public  DemoController(@Value("{server.port}") int a){
        logger.info("NEw keyword {}", a);
    }

    @GetMapping("/sample")
    public Demo getDemo(){
        //Demo demo = new Demo();
        logger.info("demo object in simple API- {}", demo);
        return demo;
    }

   /*
    Inversion of Control-Insteead
    Default scope in Spring is 'singleton'
    Other type of scopes are 'prototype'
    In prototype we spring creates the object of the class only when it we require it.


       Two ways of doing dependency Injection:
       1. Field Injection
       2. Constructor Injection



    */
}
