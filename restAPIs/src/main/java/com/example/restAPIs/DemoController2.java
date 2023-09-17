package com.example.restAPIs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class DemoController2 {

 //   private static logger
    @Autowired
    Demo demo;

    @Autowired
    DemoController demoController;

    private static final Logger logger = LoggerFactory.getLogger(DemoController2.class);
    @GetMapping("/sample")
    public Demo getDemo(){
        logger.info("demoController - {} demo of dc1{} demo of dc2{}", demoController, demoController.demo, demo);
        //Demo demo = new Demo();
        logger.info("demo object in simple API- {}", demo);
        return demo;
    }
}
