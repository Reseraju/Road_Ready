package com.hexaware.web.RoadReady.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.hexaware.web.RoadReady.DTO.SignupRequest;
import com.hexaware.web.RoadReady.DTO.UserAuthDTO;
import com.hexaware.web.RoadReady.Entity.User;
import com.hexaware.web.RoadReady.Repository.UserRepository;
import com.hexaware.web.RoadReady.enums.UserType;

@Component
public class AuthServiceImpl implements AuthService{
	
	@Autowired
    private  UserRepository userRepository;

	@Override
	public UserAuthDTO createUser(SignupRequest signupRequest) {
		User user = new User();
		user.setUsername(signupRequest.getUsername());
		user.setFirstName(signupRequest.getFirstName());
		user.setLastName(signupRequest.getLastname());
		user.setPhoneNo(signupRequest.getPhoneNo());
		user.setLicenseNo(signupRequest.getLicenseNo());
	    user.setEmail(signupRequest.getEmail());
	    user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
	    
	 // Set default role if none is provided
	    if (signupRequest.getUserType() == null) {
	        user.setUserType(UserType.Customer); // Default role to USER
	    } else {
	        user.setUserType(signupRequest.getUserType());
	    }
	    
	    User createdUser = userRepository.save(user);
	    
	 // Convert User to UserDTO to hide unnecessary fields
	    UserAuthDTO userAuthDTO = new UserAuthDTO();
	    userAuthDTO.setUserId(createdUser.getUserId());
	    userAuthDTO.setUsername(createdUser.getUsername());
	    userAuthDTO.setEmail(createdUser.getEmail());
	    userAuthDTO.setUserType(createdUser.getUserType().name());

		return userAuthDTO;  // Rewritten line without hidden characters
	}

	@Override
	public boolean hasCustomerWithEmail(String email) {
		return userRepository.findFirstByEmail(email).isPresent();
	}

}
