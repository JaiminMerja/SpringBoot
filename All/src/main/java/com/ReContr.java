package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReContr 
{
	@GetMapping("/test")
	public String testException() 
	{
		throw new MyException("This is custom exception");
	}
	
}