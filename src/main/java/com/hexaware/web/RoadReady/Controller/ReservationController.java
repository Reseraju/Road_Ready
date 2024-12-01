package com.hexaware.web.RoadReady.Controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.web.RoadReady.DTO.ReservationDTO;
import com.hexaware.web.RoadReady.Entity.Reservation;
import com.hexaware.web.RoadReady.Exception.NotFoundException;
import com.hexaware.web.RoadReady.Service.ReservationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin("http://localhost:3000")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/saveNewReservation")
    public ResponseEntity<ReservationDTO> saveNewReservation(@Valid @RequestBody ReservationDTO reservationDTO) throws NotFoundException {
        ReservationDTO savedReservationDTO = reservationService.saveReservation(reservationDTO);
        return new ResponseEntity<>(savedReservationDTO, HttpStatus.CREATED);
    }
    
    // getting all reservations
    
    @GetMapping("/getAllReservations")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() throws NotFoundException {
    	
    	List<Reservation> reservationList = reservationService.showAllReservations();
    	List<ReservationDTO> reservations = new ArrayList<>();
    	
    	for(Reservation i : reservationList) {
    		ReservationDTO r = modelMapper.map(i, ReservationDTO.class);
    		reservations.add(r);
    	}
    	
    	if(reservations.isEmpty()) {
    		throw new NotFoundException("No reservations found in database");
    	}
    	else {
    		return new ResponseEntity<>(reservations, HttpStatus.OK);
    	}
    }
    
    
    // get reservations by user id 
    @GetMapping("/getReservationsByUserId/{userId}")
    public ResponseEntity<List<ReservationDTO>> getReservationByUserId(@PathVariable int userId) throws NotFoundException {
    	
        List<Reservation> reservations = reservationService.showReservationsByUserId(userId);
        List<ReservationDTO> reservationsByUser = new ArrayList<>();
        for(Reservation i : reservations) {
        	ReservationDTO r = modelMapper.map(i, ReservationDTO.class);
        	reservationsByUser.add(r);
        }
        
        if(reservationsByUser.isEmpty()) {
        	throw new NotFoundException("No cars found in database");
        }
        else {
        	return new ResponseEntity<>(reservationsByUser, HttpStatus.OK);
        }
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
