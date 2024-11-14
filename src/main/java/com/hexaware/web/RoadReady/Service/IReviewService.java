package com.hexaware.web.RoadReady.Service;

import java.util.List;

import com.hexaware.web.RoadReady.DTO.ReviewDTO;
import com.hexaware.web.RoadReady.Entity.Review;
import com.hexaware.web.RoadReady.Exception.NotFoundException;

public interface IReviewService {
	public Review saveReview(ReviewDTO reviewDTO) throws NotFoundException;
	public List<Review> showAllReviews();
	public Review findReviewById(int id) throws NotFoundException;
	public void deleteReview(int id) throws NotFoundException;
}
