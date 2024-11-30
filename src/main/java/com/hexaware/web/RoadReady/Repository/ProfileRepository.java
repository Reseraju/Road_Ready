package com.hexaware.web.RoadReady.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.web.RoadReady.Entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Optional<Profile> findByUser_Username(String username);
}

