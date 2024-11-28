package com.hexaware.web.RoadReady.DTO;

import com.hexaware.web.RoadReady.enums.UserType;

public class UserDTO {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String licenseNo;
    private UserType userType;
    private String username;
    
    public UserDTO() {
    	
    }
    
	public UserDTO(int userId, String firstName, String lastName, String email, String phoneNo, String licenseNo,
			UserType userType, String username) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.licenseNo = licenseNo;
		this.userType = userType;
		this.username = username;
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
    
    
    public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
