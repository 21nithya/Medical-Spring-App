package com.medicalapp.medicalapi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicalApiApplication {
	private final Logger logger =LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(MedicalApiApplication.class, args);
		System.out.println("hi");
		
		
	}

}
