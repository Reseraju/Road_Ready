package com.hexaware.web.RoadReady.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	
	@NotNull(message = "User ID cannot be null")
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;
	
	@NotNull(message = "Car ID cannot be null")
    @ManyToOne(fetch = FetchType.LAZY) // Define relationship to Car entity
    @JoinColumn(name = "carId", referencedColumnName = "carId")
	private Car car;
	
	@NotNull(message = "Rating cannot be null")
    @Min(value = 1, message = "Rating should be at least 1")
    @Max(value = 5, message = "Rating should not exceed 5")
	private int rating;
	
	@Size(max = 1000, message = "Review text should not exceed 1000 characters")
	private String reviewText;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
	private Date createdAt;
	
	public Review() {
		
	}
	
	public Review(int reviewId, User user, @NotNull(message = "Car ID cannot be null") Car car,
			@NotNull(message = "Rating cannot be null") @Min(value = 1, message = "Rating should be at least 1") @Max(value = 5, message = "Rating should not exceed 5") int rating,
			@Size(max = 1000, message = "Review text should not exceed 1000 characters") String reviewText,
			Date createdAt) {
		super();
		this.reviewId = reviewId;
		this.user = user;
		this.car = car;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
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

	@PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", car=" + car + ", rating=" + rating + ", reviewText=" + reviewText
				+ ", createdAt=" + createdAt + "]";
	}
	
}
