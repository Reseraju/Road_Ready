package com.hexaware.web.RoadReady.Controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.web.RoadReady.DTO.CarDTO;
import com.hexaware.web.RoadReady.Entity.Car;
import com.hexaware.web.RoadReady.Exception.NotFoundException;
import com.hexaware.web.RoadReady.Exception.NotSavedException;
import com.hexaware.web.RoadReady.Service.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {
	@Autowired
	ModelMapper model;
	
	@Autowired
	CarService ser;
	
	
	// ------------------ SAVE NEW CAR ------------------
	
	@PostMapping("/saveNewCar")
	public ResponseEntity<?> saveNewCar(@Valid @RequestBody CarDTO car) {
		
		// mapping CarDTO to Car entity
		Car dtoToEntity = model.map(car, Car.class);
		Car c = ser.saveCarData(dtoToEntity);
		
		if(c == null) {
			throw new NotSavedException("Could not save the car!");
		}
		
		// mapping Car entity to CarDTO
		CarDTO entityToDto = model.map(c, CarDTO.class);
		return new ResponseEntity<>(entityToDto, HttpStatus.CREATED);
	}
	
	// ------------------ LIST ALL CARS ------------------
	
	@GetMapping("/getAllCars")
	public ResponseEntity<List<CarDTO>> getCarData() throws NotFoundException{
		
		List<Car> carList = ser.showAllCars();
		List<CarDTO> cars = new ArrayList<>();
		
		for(Car i : carList) {
			CarDTO c = model.map(i, CarDTO.class);
			cars.add(c);
		}
		
		if(cars.isEmpty()) {
			throw new NotFoundException("No records found in database");
		}
		else {
			return new ResponseEntity<>(cars, HttpStatus.OK);
		}
	}
	
	// ------------------ GET CAR BASED ON TYPE OF CAR ------------------
	
	@GetMapping("/getCarByType/{type}")
	public ResponseEntity<List<CarDTO>> getCarByType(@PathVariable String type) throws NotFoundException{
		
		List<Car> carList = ser.findCarByType(type);
		List<CarDTO> cars = new ArrayList<>();
		
		for(Car i : carList) {
			CarDTO c = model.map(i, CarDTO.class);
			cars.add(c);
		}
		
		if(cars.isEmpty()) {
			throw new NotFoundException("No records found in database");
		}
		else {
			return new ResponseEntity<>(cars, HttpStatus.OK);
		}
	}
	
	// ------------------ UPDATE CAR DETAILS ------------------
	
	@PutMapping("/updateCarDetailsById/{Id}")
	public ResponseEntity<CarDTO> modifyCarInfo(@PathVariable int Id ,@RequestBody @Valid CarDTO c) throws NotFoundException{
		Car carEntityObj = model.map(c, Car.class);
		Car car = ser.updateCar(Id, carEntityObj);
		CarDTO carDtoObj = model.map(car, CarDTO.class);
		return new ResponseEntity<>(carDtoObj, HttpStatus.OK);
	}
	
	// ------------------ DELETE CAR ------------------
	
	@DeleteMapping("/deleteCarById/{Id}")
	public ResponseEntity<String> delete(@PathVariable int Id) throws NotFoundException{
		ser.deleteCarById(Id);
		return new ResponseEntity<>("Car deleted successfully!", HttpStatus.OK);
		
	}
}
