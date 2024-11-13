package com.hexaware.web.RoadReady.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Car {
	@Id
    private int carId;

    @NotNull(message = "Please enter Make")
    @Size(min = 2, max = 50, message = "Make should be between 2 and 50 characters")
    private String make;

    @NotNull(message = "Please enter Model")
    @Size(min = 2, max = 50, message = "Model should be between 2 and 50 characters")
    private String model;

    @NotNull(message = "Please enter Location")
    @Size(min = 2, max = 100, message = "Location should be between 2 and 100 characters")
    private String location;

    @NotNull(message = "Please enter the image URL")
    @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", message = "Please enter a valid URL")
    private String imageURL;

    @Size(max = 1000, message = "Specifications should not exceed 1000 characters")
    private String specifications;

    @Positive(message = "Price per day must be positive")
    private double pricePerDay;
    
    @NotNull(message = "Please enter the car type")
    private String carType;

    private boolean availability;
    
    public Car() {
    	
    }

    public Car(int carId,
			@NotNull(message = "Please enter Make") @Size(min = 2, max = 50, message = "Make should be between 2 and 50 characters") String make,
			@NotNull(message = "Please enter Model") @Size(min = 2, max = 50, message = "Model should be between 2 and 50 characters") String model,
			@NotNull(message = "Please enter Location") @Size(min = 2, max = 100, message = "Location should be between 2 and 100 characters") String location,
			@NotNull(message = "Please enter the image URL") @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", message = "Please enter a valid URL") String imageURL,
			@Size(max = 1000, message = "Specifications should not exceed 1000 characters") String specifications,
			@Positive(message = "Price per day must be positive") double pricePerDay,
			@NotNull(message = "Please enter the car type") String carType, boolean availability) {
		super();
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.location = location;
		this.imageURL = imageURL;
		this.specifications = specifications;
		this.pricePerDay = pricePerDay;
		this.carType = carType;
		this.availability = availability;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", make=" + make + ", model=" + model + ", location=" + location + ", imageURL="
				+ imageURL + ", specifications=" + specifications + ", pricePerDay=" + pricePerDay + ", carType="
				+ carType + ", availability=" + availability + "]";
	}
	
}
