package com.hexaware.web.RoadReady.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class ReservationDTO {
    private int reservationId;
    private int userId;
    private int carId;
    private LocalDate pickupDate;
    private LocalDate dropoffDate;
    private LocalTime pickupTime;
    private LocalTime dropoffTime;
    private Double extraCharge;
    private String reservationStatus;
    private Date createdAt;
    
    public ReservationDTO() {
    	
    }

	public ReservationDTO(int reservationId, int userId, int carId, LocalDate pickupDate, LocalDate dropoffDate,
			LocalTime pickupTime, LocalTime dropoffTime, Double extraCharge, String reservationStatus, Date createdAt) {
		super();
		this.reservationId = reservationId;
		this.userId = userId;
		this.carId = carId;
		this.pickupDate = pickupDate;
		this.dropoffDate = dropoffDate;
		this.pickupTime = pickupTime;
		this.dropoffTime = dropoffTime;
		this.extraCharge = extraCharge;
		this.reservationStatus = reservationStatus;
		this.createdAt = createdAt;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
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

	public LocalDate getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}

	public LocalDate getDropoffDate() {
		return dropoffDate;
	}

	public void setDropoffDate(LocalDate dropoffDate) {
		this.dropoffDate = dropoffDate;
	}

	public LocalTime getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(LocalTime pickupTime) {
		this.pickupTime = pickupTime;
	}

	public LocalTime getDropoffTime() {
		return dropoffTime;
	}

	public void setDropoffTime(LocalTime dropoffTime) {
		this.dropoffTime = dropoffTime;
	}

	public Double getExtraCharge() {
		return extraCharge;
	}

	public void setExtraCharge(Double extraCharge) {
		this.extraCharge = extraCharge;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ReservationDTO [reservationId=" + reservationId + ", userId=" + userId + ", carId=" + carId
				+ ", pickupDate=" + pickupDate + ", dropoffDate=" + dropoffDate + ", pickupTime=" + pickupTime
				+ ", dropoffTime=" + dropoffTime + ", extraCharge=" + extraCharge + ", reservationStatus="
				+ reservationStatus + ", createdAt=" + createdAt + "]";
	}

    

	
}
