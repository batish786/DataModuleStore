package com.datamodulestore.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Custom {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(CustomException.class)
	public ResponseEntity customExcep(CustomException exception) {
		return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
