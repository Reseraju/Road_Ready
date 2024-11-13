package com.hexaware.web.RoadReady.Exception;

public class NotFoundException extends Exception{
	String msg;
	public NotFoundException(String msg){
		super(msg);
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
