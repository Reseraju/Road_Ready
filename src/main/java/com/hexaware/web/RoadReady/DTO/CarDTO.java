package com.hexaware.web.RoadReady.DTO;

public class CarDTO {
    private int carId;
    private String make;
    private String model;
    private String location;
    private String imageURL;
    private String specifications;
    private double pricePerDay;
    private String carType;
    private boolean availability;
    
    
    public CarDTO() {
    	
    }


	public CarDTO(int carId, String make, String model, String location, String imageURL, String specifications,
			double pricePerDay, String carType, boolean availability) {
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
		return "CarDTO [carId=" + carId + ", make=" + make + ", model=" + model + ", location=" + location
				+ ", imageURL=" + imageURL + ", specifications=" + specifications + ", pricePerDay=" + pricePerDay
				+ ", carType=" + carType + ", availability=" + availability + "]";
	}
}
