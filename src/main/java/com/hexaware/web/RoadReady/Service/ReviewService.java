package com.hexaware.web.RoadReady.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.web.RoadReady.Entity.Review;
import com.hexaware.web.RoadReady.Exception.NotFoundException;
import com.hexaware.web.RoadReady.Repository.ReviewRepo;

@Service
public class ReviewService {
	
	@Autowired 
	ReviewRepo repo;

	// --------------- ADD REVIEW ---------------
	
	public Review saveReview(Review rev) {
		repo.save(rev);
		return rev;
	}

	public List<Review> showAllReviews() {
		List<Review> reviews = repo.findAll();
		
		if(reviews.isEmpty()) {
			return null;
		}
		return reviews;
	}

	// --------------- DELETE REVIEW ---------------
	
	public void deleteReview(int id) throws NotFoundException {
		
		if(!repo.existsById(id)) {
			throw new NotFoundException("Review with id "+ id +" not found");
		}
		
		repo.deleteById(id);
		
	}

	public Review findReviewById(int id) throws NotFoundException {
		Review rev = repo.findById(id).orElseThrow(() -> new NotFoundException("cannot find review with id : " +id));
		return rev;
	}
	
	
	
	
	
	
	
	
	// --------------- EDIT REVIEW ---------------
	
	
}
