package com.hexaware.web.RoadReady.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.hexaware.web.RoadReady.DTO.UserDTO;

import jakarta.validation.Valid;

public interface IUserService {
	public ResponseEntity<UserDTO> saveNewUser(@Valid @RequestBody UserDTO userDTO);
	public ResponseEntity<UserDTO> getUserById(@PathVariable int userId);
	public ResponseEntity<UserDTO> updateUser(@PathVariable int userId, @Valid @RequestBody UserDTO userDTO);
	public ResponseEntity<String> deleteUser(@PathVariable int userId);
	public ResponseEntity<List<UserDTO>> getAllUsers();
}
