package com.example.restAPIs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApIsApplication {
	private static final Logger logger = LoggerFactory.getLogger(RestApIsApplication.class);
	public static void main(String[] args) {
		DemoController demoController = new DemoController();
		//This will not be stored in the spring container.
		logger.info("Democontroller object is {}", demoController);
		SpringApplication.run(RestApIsApplication.class, args);
	}

}
