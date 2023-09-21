package com.example.restAPIs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DemoConfig {

    private static Logger logger = LoggerFactory.getLogger(DemoConfig.class);


    //It will store it in the IOC container and no new object is created again for this. We can use it when we want to use in thr future also.
    @Bean("myBean")
    public RestTemplate getTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        logger.info("Inside getTemplate... {} Bean");
        logger.info(restTemplate.toString());
        return restTemplate;
    }
    @Bean("myNewBean")
    public RestTemplate getTemplate2(){
        RestTemplate restTemplate = new RestTemplate();
        logger.info("Inside getTemplate... {} new Bean");
        logger.info(restTemplate.toString());
        return restTemplate;
    }
}
