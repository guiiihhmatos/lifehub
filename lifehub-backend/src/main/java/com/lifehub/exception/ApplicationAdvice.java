package com.lifehub.exception;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationAdvice {
	
	
	@ExceptionHandler(emailJaCadastradoException.class)
	public ResponseEntity<ExceptionDefault> emailJaCadastrado(){
		
		ExceptionDefault exception = new ExceptionDefault("Email já cadastrado", OffsetDateTime.now());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
}
