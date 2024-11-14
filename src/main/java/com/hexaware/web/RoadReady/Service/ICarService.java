package com.hexaware.web.RoadReady.Service;

import java.util.List;

import com.hexaware.web.RoadReady.Entity.Car;
import com.hexaware.web.RoadReady.Exception.NotFoundException;

public interface ICarService {
	public Car saveCarData(Car c);
	public List<Car> showAllCars();
	public Car updateCar(int carId, Car carEntityObj) throws NotFoundException;
	public Car getCarById(int carId) throws NotFoundException;
	public void deleteCarById(int id) throws NotFoundException;
	public List<Car> findCarByType(String type) throws NotFoundException;
}
