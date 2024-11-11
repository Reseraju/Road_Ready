package com.hexaware.web.RoadReady.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.web.RoadReady.DTO.CarDTO;
import com.hexaware.web.RoadReady.Entity.Car;
import com.hexaware.web.RoadReady.Exception.CarNotSavedException;
import com.hexaware.web.RoadReady.Service.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CarController {
	@Autowired
	ModelMapper model;
	
	@Autowired
	CarService ser;
	
	@PostMapping("/saveNewCar")
	public ResponseEntity<CarDTO> saveNewCar(@Valid @RequestBody CarDTO car) {
		Car dtoToEntity = model.map(car, Car.class);
		Car c = ser.saveCarData(dtoToEntity);
		
		if(c == null) {
			throw new CarNotSavedException("Could not save the car with carId: " + car.getCarId());
		}
		CarDTO entityToDto = model.map(c, CarDTO.class);
		return new ResponseEntity<>(entityToDto, HttpStatus.CREATED);
	}
	
//	@GetMapping("/getAllCars")
//	public ResponseEntity<List<CarDTO>> getCarData(){
//		
//	}
}
