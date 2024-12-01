package com.hexaware.web.RoadReady.Service;

import com.hexaware.web.RoadReady.DTO.PaymentDTO;
import com.hexaware.web.RoadReady.Entity.Payment;
import com.hexaware.web.RoadReady.Entity.Reservation;
import com.hexaware.web.RoadReady.Exception.*;
import com.hexaware.web.RoadReady.Repository.PaymentRepository;
import com.hexaware.web.RoadReady.Repository.ReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    @Autowired
    private ModelMapper modelMapper;

    public PaymentDTO addPayment(PaymentDTO paymentDTO) {
        Payment payment = modelMapper.map(paymentDTO, Payment.class);
        if (payment.getPaymentDate() == null) {
            payment.setPaymentDate(LocalDate.now());
        }
        Payment savedPayment = paymentRepository.save(payment);
        return modelMapper.map(savedPayment, PaymentDTO.class);
    }

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(payment -> modelMapper.map(payment, PaymentDTO.class))
                .collect(Collectors.toList());
    }

    public PaymentDTO getPaymentById(int paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + paymentId));
        return modelMapper.map(payment, PaymentDTO.class);
    }
}
