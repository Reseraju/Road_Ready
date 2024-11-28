package com.hexaware.web.RoadReady.DTO;

import com.hexaware.web.RoadReady.enums.UserType;

public class SignupRequest {
	private String email;
	private String username;
    private String password;
    private String firstName;
    private String lastname;
    private String phoneNo;
    private String licenseNo;
    private UserType userType;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	@Override
	public String toString() {
		return "SignupRequest [email=" + email + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastname=" + lastname + ", phoneNo=" + phoneNo + ", licenseNo=" + licenseNo
				+ ", userType=" + userType + "]";
	}
	
}
