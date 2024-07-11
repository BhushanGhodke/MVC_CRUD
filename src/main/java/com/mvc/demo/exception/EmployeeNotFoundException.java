package com.mvc.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException() {
		
	}
	
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
	
}
