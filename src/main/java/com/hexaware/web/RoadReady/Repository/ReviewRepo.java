package com.hexaware.web.RoadReady.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.web.RoadReady.Entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
	
	
}
