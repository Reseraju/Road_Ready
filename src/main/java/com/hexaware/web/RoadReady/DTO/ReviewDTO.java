package com.hexaware.web.RoadReady.DTO;

import java.util.Date;

import com.hexaware.web.RoadReady.Entity.Car;
import com.hexaware.web.RoadReady.Entity.User;

public class ReviewDTO {
	private int reviewId;
	private User user;
	private Car car;
	private int rating;
	private String reviewText;
	private Date createdAt;
}
