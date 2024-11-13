package com.hexaware.web.RoadReady.Service;

import com.hexaware.web.RoadReady.DTO.UserDTO;
import com.hexaware.web.RoadReady.Entity.User;
import com.hexaware.web.RoadReady.Exception.UserNotFoundException;
import com.hexaware.web.RoadReady.Exception.UserNotSavedException;
import com.hexaware.web.RoadReady.Repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	 @Autowired
	    private ModelMapper modelMapper;

	    // Save
	 	public UserDTO saveUser(UserDTO userDTO) {
	        User user = modelMapper.map(userDTO, User.class);

	        try {
	            User savedUser = userRepository.save(user);
	            return modelMapper.map(savedUser, UserDTO.class);
	        } catch (Exception e) {
	            throw new UserNotSavedException("Could not save the user with userId: " + userDTO.getUserId());
	        }
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

}
