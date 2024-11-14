package com.hexaware.web.RoadReady.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.web.RoadReady.DTO.ReviewDTO;
import com.hexaware.web.RoadReady.DTO.UserDTO;
import com.hexaware.web.RoadReady.Entity.Car;
import com.hexaware.web.RoadReady.Entity.Review;
import com.hexaware.web.RoadReady.Entity.User;
import com.hexaware.web.RoadReady.Exception.NotFoundException;
import com.hexaware.web.RoadReady.Repository.ReviewRepo;

@Service
public class ReviewService implements IReviewService{
	
	@Autowired 
	ReviewRepo repo;
	
	@Autowired
    private UserService userService;
    
    @Autowired
    private CarService carService;
    
    @Autowired
    private ModelMapper modelMapper;

	// --------------- ADD REVIEW ---------------
	
//	public Review saveReview(Review rev) {
//		repo.save(rev);
//		return rev;
//	}
    
    public Review saveReview(ReviewDTO reviewDTO) throws NotFoundException {
        // Fetch User and Car entities using IDs from ReviewDTO
        User user = userService.getUserById(reviewDTO.getUserId());
        Car car = carService.getCarById(reviewDTO.getCarId());

        // Map ReviewDTO to Review entity
        Review review = modelMapper.map(reviewDTO, Review.class);

        // Set the User and Car entities in the Review
        review.setUser(user);
        review.setCar(car);

        // Save Review and map back to DTO
        Review savedReview = repo.save(review);
        return savedReview;
    }
	
	// --------------- LIST ALL REVIEWS ---------------

	public List<Review> showAllReviews() {
		List<Review> reviews = repo.findAll();
		
		if(reviews.isEmpty()) {
			return null;
		}
		return reviews;
	}
	
	// --------------- GET REVIEW BY ID ---------------

		public Review findReviewById(int id) throws NotFoundException {
			Review rev = repo.findById(id).orElseThrow(() -> new NotFoundException("cannot find review with id : " +id));
			return rev;
		}

	// --------------- DELETE REVIEW ---------------
	
	public void deleteReview(int id) throws NotFoundException {
		
		if(!repo.existsById(id)) {
			throw new NotFoundException("Review with id "+ id +" not found");
		}
		
		repo.deleteById(id);
		
	}
	
	
	
	// --------------- EDIT REVIEW ---------------
	
	
}
