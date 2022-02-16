package com.datamodulestore.spring.message;

public class ResponseMessage {
	
	private boolean error;
	private String message;
	private Object data;
	public ResponseMessage() {
		super();
	}
	public ResponseMessage(boolean error, String message, Object data) {
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
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
		return "ResponseMessage [error=" + error + ", message=" + message + ", data=" + data + "]";
	}
	
	

}
