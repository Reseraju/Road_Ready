package com.hexaware.web.RoadReady.DTO;

import com.hexaware.web.RoadReady.enums.UserType;

public class AuthenticationResponse {
	private String jwt;
	private UserType userType;
	private int userId;
	
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "AuthenticationResponse [jwt=" + jwt + ", userType=" + userType + ", userId=" + userId + "]";
	}
	
	
}
