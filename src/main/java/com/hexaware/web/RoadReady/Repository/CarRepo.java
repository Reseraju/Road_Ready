package com.hexaware.web.RoadReady.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.web.RoadReady.Entity.Car;

public interface CarRepo extends JpaRepository<Car, Integer>{
	
	// case insensitive search for car type.
	@Query("SELECT c FROM Car c WHERE LOWER(c.carType) = LOWER(:carType)")
    List<Car> findByCarTypeIgnoreCase(@Param("carType") String carType);
	
	
	@Query("SELECT COUNT(c) FROM Car c")
	long countTotalCars();
}
