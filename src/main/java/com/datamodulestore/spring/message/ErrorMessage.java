package com.datamodulestore.spring.message;

public class ErrorMessage {
	
	private boolean error;
	private Object message;
	private Object data;
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(boolean error, Object message, Object data) {
		super();
		this.error = error;
		this.message = message;
		this.data = data;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ErrorMessage [error=" + error + ", message=" + message + ", data=" + data + "]";
	}

	
}
