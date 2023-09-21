package com.example.restAPIs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1")
public class DemoController2 {

 //   private static logger
    @Autowired
    Demo demo;


    //synchronized --> critical section
    ///application context --> ioc container

    @Autowired
    DemoController demoController;
//If two beans of same return type but with different bean name then we can use @Qualifier to distinguish which bean name to use
    @Autowired
    @Qualifier("myBean")
    RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(DemoController2.class);
    @GetMapping("/sample")
    public Demo getDemo(){
        logger.info("demoController - {} demo of dc1{} demo of dc2{}", demoController, demoController.demo, demo);
        //Demo demo = new Demo();
        logger.info("demo object in simple API- {}", demo);
        return demo;
    }
}
