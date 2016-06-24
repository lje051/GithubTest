package com.choa.s8;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class MyExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String ex(Exception e){
		return "error/error500";
	}
}
