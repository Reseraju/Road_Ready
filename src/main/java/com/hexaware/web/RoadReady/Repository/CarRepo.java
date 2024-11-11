package com.hexaware.web.RoadReady.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.web.RoadReady.Entity.Car;

public interface CarRepo extends JpaRepository<Car, Integer>{
	
}
