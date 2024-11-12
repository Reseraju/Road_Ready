package com.hexaware.web.RoadReady.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.web.RoadReady.Entity.Car;
import com.hexaware.web.RoadReady.Exception.CarNotFoundException;
import com.hexaware.web.RoadReady.Exception.UpdateException;
import com.hexaware.web.RoadReady.Repository.CarRepo;

@Service
public class CarService {
	@Autowired
	CarRepo repo;
	
	// SAVE NEW CAR
	public Car saveCarData(Car c) {
		return repo.save(c);
	}
	
	// LIST ALL CARS
	public List<Car> showAllCars() {
		List<Car> cars = repo.findAll();
		
		if(cars.isEmpty()) {
			return null;
		}
		return cars;
	}

	// UPDATE CAR DETAILS
	public Car updateCar(int carId, Car carEntityObj) throws UpdateException {
		
		Car car = repo.findById(carId).orElseThrow(() -> new UpdateException("Car details cannot be updated!"));
		
		car.setMake(carEntityObj.getMake());
		car.setModel(carEntityObj.getModel());
		car.setLocation(carEntityObj.getLocation());
		car.setImageURL(carEntityObj.getImageURL());
		car.setSpecifications(carEntityObj.getSpecifications());
		car.setPricePerDay(carEntityObj.getPricePerDay());
		car.setAvailability(carEntityObj.isAvailability());
		
		return repo.save(car);
	}

	public void deleteCarById(int id) throws CarNotFoundException {
		
		if(!repo.existsById(id)) {
			throw new CarNotFoundException("Car not found!");
		}
		
		repo.deleteById(id);
		
	}
}
