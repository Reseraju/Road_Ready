package com.hexaware.web.RoadReady.Exception;

public class CarNotFoundException extends Exception{
	String msg;
	public CarNotFoundException(String msg){
		super(msg);
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
