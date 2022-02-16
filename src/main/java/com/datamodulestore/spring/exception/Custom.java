package com.datamodulestore.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.datamodulestore.spring.message.ErrorMessage;

@ControllerAdvice
public class Custom {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorMessage> customExcep(CustomException exception) {
		return new ResponseEntity(new ErrorMessage(true, exception.getMessage(), null), HttpStatus.NOT_FOUND);
	}

}
