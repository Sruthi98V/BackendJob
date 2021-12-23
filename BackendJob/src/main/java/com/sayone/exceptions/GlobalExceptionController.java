package com.sayone.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sayone.model.ErrorMessage;



@RestControllerAdvice
@PropertySource({"classpath:message.properties"})
public class GlobalExceptionController {
	@Autowired
	private Environment environment;
	
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> exceptionHandler(GlobalExceptions global) {
		ErrorMessage msg = new ErrorMessage();
		msg.setMessage(environment.getProperty(global.getMessage()));
		return ResponseEntity.ok(msg);
	}
}
