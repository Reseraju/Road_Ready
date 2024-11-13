package com.hexaware.web.RoadReady.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {
    @Id
    private int userId;

    @NotNull(message = "Please enter First Name")
    @Size(min = 2, max = 50, message = "First Name should be between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Please enter Last Name")
    @Size(min = 2, max = 50, message = "Last Name should be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Please enter Email")
    @Email(message = "Please enter a valid Email")
    private String email;

    @NotNull(message = "Please enter Password")
    @Size(min = 8, message = "Password should be at least 8 characters long")
    private String password;

    @NotNull(message = "Please enter Phone Number")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Please enter a valid Phone Number")
    private String phoneNo;

    @NotNull(message = "Please enter License Number")
    @Size(min = 5, max = 20, message = "License Number should be between 5 and 20 characters")
    private String licenseNo;

    @NotNull(message = "Please specify User Type")
    @Pattern(regexp = "^(Admin|Customer)$", message = "User Type must be either 'Admin' or 'Customer'")
    private String userType;

    public User() {
    	
    }

    public User(int userId,
                @NotNull(message = "Please enter First Name") @Size(min = 2, max = 50, message = "First Name should be between 2 and 50 characters") String firstName,
                @NotNull(message = "Please enter Last Name") @Size(min = 2, max = 50, message = "Last Name should be between 2 and 50 characters") String lastName,
                @NotNull(message = "Please enter Email") @Email(message = "Please enter a valid Email") String email,
                @NotNull(message = "Please enter Password") @Size(min = 8, message = "Password should be at least 8 characters long") String password,
                @NotNull(message = "Please enter Phone Number") @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Please enter a valid Phone Number") String phoneNo,
                @NotNull(message = "Please enter License Number") @Size(min = 5, max = 20, message = "License Number should be between 5 and 20 characters") String licenseNo,
                @NotNull(message = "Please specify User Type") @Pattern(regexp = "^(Admin|Customer)$", message = "User Type must be either 'Admin' or 'Customer'") String userType) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.licenseNo = licenseNo;
        this.userType = userType;
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNo=" + phoneNo + ", licenseNo=" + licenseNo + ", userType="
				+ userType + "]";
	}

    }
