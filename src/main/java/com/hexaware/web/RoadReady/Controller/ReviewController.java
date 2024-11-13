package com.hexaware.web.RoadReady.Controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.web.RoadReady.DTO.ReviewDTO;
import com.hexaware.web.RoadReady.Entity.Review;
import com.hexaware.web.RoadReady.Exception.NotFoundException;
import com.hexaware.web.RoadReady.Exception.NotSavedException;
import com.hexaware.web.RoadReady.Service.ReviewService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
	@Autowired
	ModelMapper model;
	
	@Autowired
	ReviewService ser;
	
	// --------------- ADD REVIEW ---------------
	
	@PostMapping("/saveNewReview")
	public ResponseEntity<?> saveNewReview(@Valid @RequestBody  ReviewDTO review){
		
		Review rev = model.map(review, Review.class);
		Review r = ser.saveReview(rev);
		
		if(r == null) {
			throw new NotSavedException("Could not save the review");
		}
		
		Review reviewDto = model.map(r, Review.class);
		return new ResponseEntity<>(reviewDto, HttpStatus.CREATED);
	}
	
	// --------------- LIST ALL REVIEWS ---------------
	
	@GetMapping("/allReviews")
	public ResponseEntity<List<ReviewDTO>> getAllReview() throws NotFoundException {
		List<Review> reviewList = ser.showAllReviews();
		List<ReviewDTO> reviews = new ArrayList<>();
		
		for(Review i : reviewList) {
			ReviewDTO c = model.map(i, ReviewDTO.class);
			reviews.add(c);
		}
		
		if(reviews.isEmpty()) {
			throw new NotFoundException("No records found in database");
		}
		else {
			return new ResponseEntity<>(reviews, HttpStatus.OK);
		}
	}
	
	// --------------- GET REVIEW BY ID ---------------
	
	@GetMapping("/getReviewById/{Id}")
	public ResponseEntity<ReviewDTO> getReviewById(@PathVariable int Id) throws NotFoundException {
		Review review = ser.findReviewById(Id);
		ReviewDTO revDto = model.map(review, ReviewDTO.class);
		
		return new ResponseEntity<>(revDto, HttpStatus.OK);
	}
	
	
	
	// --------------- DELETE REVIEW ---------------
	
	@DeleteMapping("/deleteReviewById/{Id}")
	public ResponseEntity<String> deleteReviewById(@PathVariable int Id) throws NotFoundException{
		ser.deleteReview(Id);
		return new ResponseEntity<>("Car deleted successfully!", HttpStatus.OK);
	}
}
