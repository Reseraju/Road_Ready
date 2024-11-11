package com.hexaware.web.RoadReady.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
public class Payment {

    @Id
    private int paymentId;

    @NotNull(message = "Reservation ID is required")
    @ManyToOne
    @JoinColumn(name = "reservationId", referencedColumnName = "reservationId")
    private Reservation reservation;

    @Positive(message = "Amount must be positive")
    private double amount;

    @NotNull(message = "Payment Date is required")
    @PastOrPresent(message = "Payment Date cannot be in the future")
    private LocalDate paymentDate;

    @NotNull(message = "Payment Method is required")
    private String paymentMethod;

    @NotNull(message = "Payment Status is required")
    private String paymentStatus;

    public Payment() {
    	
    }

    public Payment(int paymentId, 
                   @NotNull(message = "Reservation ID is required") Reservation reservation,
                   @Positive(message = "Amount must be positive") double amount,
                   @NotNull(message = "Payment Date is required") @PastOrPresent(message = "Payment Date cannot be in the future") LocalDate paymentDate,
                   @NotNull(message = "Payment Method is required") String paymentMethod,
                   @NotNull(message = "Payment Status is required") String paymentStatus) {
        this.paymentId = paymentId;
        this.reservation = reservation;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", reservation=" + reservation + ", amount=" + amount
               + ", paymentDate=" + paymentDate + ", paymentMethod=" + paymentMethod + ", paymentStatus=" + paymentStatus + "]";
    }
}
