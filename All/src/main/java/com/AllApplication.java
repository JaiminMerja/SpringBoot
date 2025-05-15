package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;

@SpringBootApplication
@RestController
@ControllerAdvice
//@EnableScheduling
public class AllApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(AllApplication.class, args);
	}

}
