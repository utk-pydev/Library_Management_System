package com.example.restAPIs;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;
@Configuration
public class DemoConfig {

    private static Logger logger = (Logger) LoggerFactory.getLogger(DemoConfig.class);


    //It will store it in the IOC container and no new object is created again for this. We can use it when we want to use in thr future also.
    @Bean
    public RestTemplate getTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        logger.info("Inside getTemplate... {}");
        logger.info(restTemplate.toString());
        return restTemplate;
    }
}
