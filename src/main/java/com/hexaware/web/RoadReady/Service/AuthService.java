package com.hexaware.web.RoadReady.Service;

import com.hexaware.web.RoadReady.DTO.SignupRequest;
import com.hexaware.web.RoadReady.DTO.UserAuthDTO;

public interface AuthService {
	UserAuthDTO createUser(SignupRequest signupRequest);
	
	boolean hasCustomerWithEmail(String email);
}
