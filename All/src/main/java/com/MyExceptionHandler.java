package com;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler 
{
	@ExceptionHandler(MyException.class)
	public ResponseEntity<String>handleMyException(MyException ex) 
	{
        return new ResponseEntity<>("Caught exception: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
