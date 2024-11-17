package com.hexaware.web.RoadReady.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.web.RoadReady.DTO.UserPrincipal;
import com.hexaware.web.RoadReady.Entity.User;
import com.hexaware.web.RoadReady.Repository.UserRepository;

@Service
public class UserPrincipalService implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
        
        return new UserPrincipal(user);
    }
}
