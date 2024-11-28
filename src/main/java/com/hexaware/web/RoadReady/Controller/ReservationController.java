package com.hexaware.web.RoadReady.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.web.RoadReady.DTO.ReservationDTO;
import com.hexaware.web.RoadReady.Exception.NotFoundException;
import com.hexaware.web.RoadReady.Service.ReservationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin("http://localhost:3000")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/saveNewReservation")
    public ResponseEntity<ReservationDTO> saveNewReservation(@Valid @RequestBody ReservationDTO reservationDTO) throws NotFoundException {
        ReservationDTO savedReservationDTO = reservationService.saveReservation(reservationDTO);
        return new ResponseEntity<>(savedReservationDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable int reservationId) {
        ReservationDTO reservationDTO = reservationService.getReservationById(reservationId);
        return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
    }

    @PutMapping("/updateReservation/{reservationId}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable int reservationId,
                                                             @Valid @RequestBody ReservationDTO reservationDTO) {
        ReservationDTO updatedReservationDTO = reservationService.updateReservation(reservationId, reservationDTO);
        return new ResponseEntity<>(updatedReservationDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteReservation/{reservationId}")
    public ResponseEntity<String> deleteReservation(@PathVariable int reservationId) {
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity<>("Reservation with ID " + reservationId + " deleted successfully.", HttpStatus.OK);
    }
}
