package com.hexaware.web.RoadReady.Exception;

public class ResourceNotFoundException extends Exception {
	String msg;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
