package com.hexaware.web.RoadReady.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.web.RoadReady.Entity.Profile;
import com.hexaware.web.RoadReady.Repository.ProfileRepository;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/current")
    public ResponseEntity<Profile> getCurrentProfile(Authentication authentication) {
        String username = authentication.getName(); // Get logged-in user's username
        Profile profile = profileRepository.findByUser_Username(username)
                             .orElseThrow(() -> new RuntimeException("Profile not found"));
        return ResponseEntity.ok(profile);
    }
}
