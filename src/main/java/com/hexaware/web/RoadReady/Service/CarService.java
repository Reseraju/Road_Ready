package com.hexaware.web.RoadReady.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.web.RoadReady.Entity.Car;
import com.hexaware.web.RoadReady.Repository.CarRepo;

@Service
public class CarService {
	@Autowired
	CarRepo repo;
	
	public Car saveCarData(Car c) {
		return repo.save(c);
	}
}
