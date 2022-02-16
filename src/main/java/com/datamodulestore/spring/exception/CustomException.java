package com.datamodulestore.spring.exception;


@SuppressWarnings("serial")
public class CustomException extends RuntimeException {

	public CustomException(String msg) {
		super(msg);
	}
}
