package com.hexaware.web.RoadReady.Exception;

public class NotSavedException extends RuntimeException{
	String msg;
	
	public NotSavedException(String msg) {
		super();
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
