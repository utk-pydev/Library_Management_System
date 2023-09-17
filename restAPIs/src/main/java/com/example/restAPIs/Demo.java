package com.example.restAPIs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
//Since the scope of this is prototype so while depenendency iinjection of demo seperated insatance is created for this.
public class Demo {
    private int id;
    private String name;

    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    public Demo(){
        logger.info("Creating demo object ...{}", this);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}


