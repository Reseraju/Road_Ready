package com.hexaware.web.RoadReady.Exception;

public class UpdateException extends Exception{
	String msg;
	
	public UpdateException(String msg){
		super(msg);
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
