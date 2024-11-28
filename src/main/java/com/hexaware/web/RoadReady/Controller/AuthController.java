package com.hexaware.web.RoadReady.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.web.RoadReady.DTO.AuthenticationRequest;
import com.hexaware.web.RoadReady.DTO.AuthenticationResponse;
import com.hexaware.web.RoadReady.DTO.SignupRequest;
import com.hexaware.web.RoadReady.DTO.UserAuthDTO;
import com.hexaware.web.RoadReady.DTO.UserDTO;
import com.hexaware.web.RoadReady.Entity.User;
import com.hexaware.web.RoadReady.Repository.UserRepository;
import com.hexaware.web.RoadReady.Service.AuthService;
import com.hexaware.web.RoadReady.Service.JWTService;
import com.hexaware.web.RoadReady.Service.UserPrincipalService;
import com.hexaware.web.RoadReady.Service.UserService;



@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
    private  AuthService authService;
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private  AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserPrincipalService userPrincipalService;
	
	@Autowired
    private  JWTService jwtService;
	
	@Autowired
    private  UserRepository userRepository;
	
	
	@PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        if (authService.hasCustomerWithEmail(signupRequest.getEmail()))
            return new ResponseEntity<>("Customer already exists", HttpStatus.NOT_ACCEPTABLE);

        UserAuthDTO createdCustomerDto = authService.createUser(signupRequest);

        if (createdCustomerDto == null) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
    }
	
	
	@PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException badCredentialsException) {
            throw new BadCredentialsException("Incorrect Email Or Password.");
        }
        
        final UserDetails userDetails = userPrincipalService.loadUserByUsername(authenticationRequest.getEmail());
        Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
        final String jwt = jwtService.generateToken(userDetails.getUsername());
        
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        if (optionalUser.isPresent()) {
            authenticationResponse.setJwt(jwt);
            authenticationResponse.setUserId(optionalUser.get().getUserId());
            authenticationResponse.setUserType(optionalUser.get().getUserType());
        }
        return ResponseEntity.ok(authenticationResponse);
    }
	
//	@PostMapping("/login")
//    public String login(@RequestBody UserDTO userDTO) {
//    	return userService.verify(userDTO);
//    }
	
	
}
