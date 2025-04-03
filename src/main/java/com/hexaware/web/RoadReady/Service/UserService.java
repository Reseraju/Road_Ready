package com.hexaware.web.RoadReady.Service;

import com.hexaware.web.RoadReady.DTO.UserDTO;
import com.hexaware.web.RoadReady.DTO.UserPrincipal;
import com.hexaware.web.RoadReady.Entity.User;
import com.hexaware.web.RoadReady.Exception.UserNotFoundException;
import com.hexaware.web.RoadReady.Exception.UserNotSavedException;
import com.hexaware.web.RoadReady.Repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JWTService jwtService;
	
	@Autowired
	AuthenticationManager authManager;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	 @Autowired
	    private ModelMapper modelMapper;

	    // Save
	 	public UserDTO saveUser(UserDTO userDTO) {
	        User user = modelMapper.map(userDTO, User.class);

	        try {
	        	user.setPassword(encoder.encode(user.getPassword()));
	            User savedUser = userRepository.save(user);
	            return modelMapper.map(savedUser, UserDTO.class);
	        } catch (Exception e) {
	        	e.printStackTrace();
	            throw new UserNotSavedException("Could not save the user with userId: " + userDTO.getUserId());
	        }
	    }
	 	
	 	// GET TOTAL NO. OF USERS
		public long getTotalUsers() {
			return userRepository.countTotalUsers();
		}
	    
	    
	 	// Find id
	    public User getUserById(int userId) {
	        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with userId: " + userId));
	        return user;
	    }
	    
	    //update
	    public UserDTO updateUser(int userId, UserDTO userDTO) {
	        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with userId: " + userId));
	        user.setFirstName(userDTO.getFirstName());
	        user.setLastName(userDTO.getLastName());
	        user.setEmail(userDTO.getEmail());
	        user.setPhoneNo(userDTO.getPhoneNo());
	        user.setLicenseNo(userDTO.getLicenseNo());
	        user.setUserType(userDTO.getUserType());
	        User updatedUser = userRepository.save(user);
	        return modelMapper.map(updatedUser, UserDTO.class);
	    }
	    
	    // Delete 
	    public void deleteUser(int userId) {
	        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with userId: " + userId));
	        userRepository.delete(user);
	    }

	    // get all users
	    public List<UserDTO> getAllUsers() {
	        List<User> users = userRepository.findAll();
	        return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	    }

	    
	    
	    // verifying a user
		public String verify(UserDTO userDTO) {
			User user = modelMapper.map(userDTO, User.class);
			
			Authentication authentication = 
					authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			
			if(authentication.isAuthenticated()) {
				return jwtService.generateToken(user.getEmail());
			}
			return "fail";
		}
}
