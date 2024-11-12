package com.hexaware.web.RoadReady.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.hexaware.web.RoadReady.Entity.Car;
import com.hexaware.web.RoadReady.Entity.User;

public class ReservationDTO {
	private int reservationId;
    private User user;
    private Car car;
    private LocalDate pickupDate;
    private LocalDate dropoffDate;
    private LocalTime pickupTime;
    private LocalTime dropoffTime;
    private double extraCharge;
    private String reservationStatus;
    private LocalDateTime createdAt;
}
