package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootMessageApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootMessageApplication.class, args);
	}
}
