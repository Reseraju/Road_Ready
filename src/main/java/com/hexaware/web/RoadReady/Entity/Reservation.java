package com.hexaware.web.RoadReady.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    private int reservationId;

    @NotNull(message = "User ID is required")
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @NotNull(message = "Car ID is required")
    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "carId")
    private Car car;

    @NotNull(message = "Pickup Date is required")
    @FutureOrPresent(message = "Pickup Date cannot be in the past")
    private LocalDate pickupDate;

    @NotNull(message = "Dropoff Date is required")
    @FutureOrPresent(message = "Dropoff Date cannot be in the past")
    private LocalDate dropoffDate;

    @NotNull(message = "Pickup Time is required")
    private LocalTime pickupTime;

    @NotNull(message = "Dropoff Time is required")
    private LocalTime dropoffTime;

    @PositiveOrZero(message = "Extra charge must be zero or positive")
    private double extraCharge;

    @NotNull(message = "Reservation Status is required")
    private String reservationStatus;

    @NotNull(message = "Creation timestamp is required")
    private LocalDateTime createdAt;

    public Reservation() {
    	
    }

    public Reservation(int reservationId,
                       @NotNull(message = "User ID is required") User user,
                       @NotNull(message = "Car ID is required") Car car,
                       @NotNull(message = "Pickup Date is required") @FutureOrPresent(message = "Pickup Date cannot be in the past") LocalDate pickupDate,
                       @NotNull(message = "Dropoff Date is required") @FutureOrPresent(message = "Dropoff Date cannot be in the past") LocalDate dropoffDate,
                       @NotNull(message = "Pickup Time is required") LocalTime pickupTime,
                       @NotNull(message = "Dropoff Time is required") LocalTime dropoffTime,
                       @PositiveOrZero(message = "Extra charge must be zero or positive") double extraCharge,
                       @NotNull(message = "Reservation Status is required") String reservationStatus,
                       @NotNull(message = "Creation timestamp is required") LocalDateTime createdAt) {
        this.reservationId = reservationId;
        this.user = user;
        this.car = car;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
        this.pickupTime = pickupTime;
        this.dropoffTime = dropoffTime;
        this.extraCharge = extraCharge;
        this.reservationStatus = reservationStatus;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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

    public double getExtraCharge() {
        return extraCharge;
    }

    public void setExtraCharge(double extraCharge) {
        this.extraCharge = extraCharge;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Reservation [reservationId=" + reservationId + ", user=" + user + ", car=" + car + ", pickupDate=" + pickupDate 
               + ", dropoffDate=" + dropoffDate + ", pickupTime=" + pickupTime + ", dropoffTime=" + dropoffTime 
               + ", extraCharge=" + extraCharge + ", reservationStatus=" + reservationStatus + ", createdAt=" + createdAt + "]";
    }
}
