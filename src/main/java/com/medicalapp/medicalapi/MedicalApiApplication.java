package com.medicalapp.medicalapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
public class MedicalApiApplication {
	//private final Logger logger =LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(MedicalApiApplication.class, args);
		log.info("hi");
		
		
	}

}
