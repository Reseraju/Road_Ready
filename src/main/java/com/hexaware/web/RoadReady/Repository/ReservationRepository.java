package com.hexaware.web.RoadReady.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.web.RoadReady.Entity.Reservation;



@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer>{
	
}