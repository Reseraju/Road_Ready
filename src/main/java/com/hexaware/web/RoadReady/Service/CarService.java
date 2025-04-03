package com.hexaware.web.RoadReady.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.web.RoadReady.DTO.CarDTO;
import com.hexaware.web.RoadReady.DTO.UserDTO;
import com.hexaware.web.RoadReady.Entity.Car;
import com.hexaware.web.RoadReady.Exception.NotFoundException;
import com.hexaware.web.RoadReady.Repository.CarRepo;

@Service
public class CarService implements ICarService {
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
	
	// GET TOTAL NO. OF CARS
	public long getTotalCars() {
		return repo.countTotalCars();
	}

	// UPDATE CAR DETAILS
	public Car updateCar(int carId, Car carEntityObj) throws NotFoundException {
		
		Car car = repo.findById(carId).orElseThrow(() -> new NotFoundException("Car details cannot be updated! Because Car not found"));
		
		car.setMake(carEntityObj.getMake());
		car.setModel(carEntityObj.getModel());
		car.setLocation(carEntityObj.getLocation());
		car.setImageURL(carEntityObj.getImageURL());
		car.setSpecifications(carEntityObj.getSpecifications());
		car.setPricePerDay(carEntityObj.getPricePerDay());
		car.setCarType(carEntityObj.getCarType());
		car.setAvailability(carEntityObj.isAvailability());
		
		return repo.save(car);
	}
	
	// find car by id
	public Car getCarById(int carId) throws NotFoundException {
		Car car = repo.findById(carId).orElseThrow(() -> new NotFoundException("Car not found with carId: " + carId));
		return car;
	}
	
	// DELETE A CAR BY ID
	public void deleteCarById(int id) throws NotFoundException {
		
		if(!repo.existsById(id)) {
			throw new NotFoundException("Car not found!");
		}
		
		repo.deleteById(id);
	}
	
	// search Car By CarType
	public List<Car> findCarByType(String type) throws NotFoundException {
		List<Car> cars = repo.findByCarTypeIgnoreCase(type);
		
		if (cars.isEmpty()) {
            throw new NotFoundException("No cars found for type: " + type);
        }
		return cars;
	}
}
