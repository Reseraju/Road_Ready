package com.hexaware.web.RoadReady.DTO;

import java.util.Date;

import com.hexaware.web.RoadReady.Entity.Car;
import com.hexaware.web.RoadReady.Entity.User;

public class ReviewDTO {
	private int reviewId;
    private int userId; 
    private int carId;  
    private int rating;
    private String reviewText;
    private Date createdAt;
    
    public ReviewDTO() {
    	
    }
	public ReviewDTO(int reviewId, int userId, int carId, int rating, String reviewText, Date createdAt) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.carId = carId;
		this.rating = rating;
		this.reviewText = reviewText;
		this.createdAt = createdAt;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "ReviewDTO [reviewId=" + reviewId + ", userId=" + userId + ", carId=" + carId + ", rating=" + rating
				+ ", reviewText=" + reviewText + ", createdAt=" + createdAt + "]";
	}
    
}
