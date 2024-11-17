package com.hexaware.web.RoadReady.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @NotNull(message = "Payment amount is required")
    @Positive(message = "Payment amount must be positive")
    private double amount;

    @NotNull(message = "Payment method is required")
    private String paymentMethod;
    
    @NotNull(message = "Payment date is required")
    private LocalDate paymentDate;

    public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	@NotNull(message = "Payment timestamp is required")
    private LocalDateTime paymentTimestamp;

    @NotNull(message = "Reservation is required")
    @ManyToOne
    @JoinColumn(name = "reservationId", referencedColumnName = "reservationId")
    private Reservation reservation;
    
    @NotNull(message = "Payment status is required")
    private String paymentStatus = "PENDING";

    // Default constructor
    public Payment() {}


    

	public Payment(int paymentId,
			@NotNull(message = "Payment amount is required") @Positive(message = "Payment amount must be positive") double amount,
			@NotNull(message = "Payment method is required") String paymentMethod,
			@NotNull(message = "Payment date is required") LocalDate paymentDate,
			@NotNull(message = "Payment timestamp is required") LocalDateTime paymentTimestamp,
			@NotNull(message = "Reservation is required") Reservation reservation,
			@NotNull(message = "Payment status is required") String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
		this.paymentTimestamp = paymentTimestamp;
		this.reservation = reservation;
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	// Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getPaymentTimestamp() {
        return paymentTimestamp;
    }

    public void setPaymentTimestamp(LocalDateTime paymentTimestamp) {
        this.paymentTimestamp = paymentTimestamp;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", paymentMethod=" + paymentMethod
				+ ", paymentDate=" + paymentDate + ", paymentTimestamp=" + paymentTimestamp + ", reservation="
				+ reservation + ", paymentStatus=" + paymentStatus + "]";
	}
}
