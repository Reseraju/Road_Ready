package com.hexaware.web.RoadReady.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaymentDTO {

	private int paymentId;
    private double amount;
    private String paymentMethod;
    private LocalDateTime paymentTimestamp;
    private LocalDate paymentDate;
    private int reservationId;
    private String paymentStatus = "PENDING";

    public PaymentDTO() {}

    

    public PaymentDTO(int paymentId, double amount, String paymentMethod, LocalDateTime paymentTimestamp,
			LocalDate paymentDate, int reservationId, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentTimestamp = paymentTimestamp;
		this.paymentDate = paymentDate;
		this.reservationId = reservationId;
		this.paymentStatus = paymentStatus;
	}



	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

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
    
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
	public String toString() {
		return "PaymentDTO [paymentId=" + paymentId + ", amount=" + amount + ", paymentMethod=" + paymentMethod
				+ ", paymentTimestamp=" + paymentTimestamp + ", paymentDate=" + paymentDate + ", reservationId="
				+ reservationId + ", paymentStatus=" + paymentStatus + "]";
	}
}
