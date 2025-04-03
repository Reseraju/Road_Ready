package com.hexaware.web.RoadReady.Controller;

import com.hexaware.web.RoadReady.DTO.UserDTO;
import com.hexaware.web.RoadReady.Entity.User;
import com.hexaware.web.RoadReady.Service.IUserService;
import com.hexaware.web.RoadReady.Service.UserService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@Validated
public class UserController{

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    // new user addng
    @PostMapping("/saveNewUser")
    public ResponseEntity<UserDTO> saveNewUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO savedUserDTO = userService.saveUser(userDTO);
        return new ResponseEntity<>(savedUserDTO, HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO) {
    	return userService.verify(userDTO);
    }
    
    //find user
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
    
    //update
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int userId, @Valid @RequestBody UserDTO userDTO) {
        UserDTO updatedUserDTO = userService.updateUser(userId, userDTO);
        return new ResponseEntity<>(updatedUserDTO, HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    //get all
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
 // ------------------ GET TOTAL USERS ------------------
	
 	@GetMapping("/getTotalNoOfUsers")
 	public Long getTotalUsers() {
 		return userService.getTotalUsers();
 	}
}

