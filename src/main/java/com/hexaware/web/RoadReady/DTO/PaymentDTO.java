package com.hexaware.web.RoadReady.DTO;

import java.time.LocalDate;

import com.hexaware.web.RoadReady.Entity.Reservation;

public class PaymentDTO {
	private int paymentId;
    private Reservation reservation;
    private double amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String paymentStatus;
}
