package com.hexaware.web.RoadReady.Controller;

import com.hexaware.web.RoadReady.DTO.PaymentDTO;
import com.hexaware.web.RoadReady.Service.PaymentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@CrossOrigin("http://localhost:3000")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity<PaymentDTO> addPayment(@Valid @RequestBody PaymentDTO paymentDTO) {
        if (paymentDTO.getPaymentDate() == null) {
            paymentDTO.setPaymentDate(java.time.LocalDate.now());
        }
        if (paymentDTO.getPaymentTimestamp() == null) {
            paymentDTO.setPaymentTimestamp(java.time.LocalDateTime.now());
        }
        if (paymentDTO.getPaymentStatus() == null || paymentDTO.getPaymentStatus().isEmpty()) {
            paymentDTO.setPaymentStatus("PENDING");
        }
        PaymentDTO savedPayment = paymentService.addPayment(paymentDTO);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        List<PaymentDTO> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable int paymentId) {
        PaymentDTO paymentDTO = paymentService.getPaymentById(paymentId);
        return new ResponseEntity<>(paymentDTO, HttpStatus.OK);
    }
}
