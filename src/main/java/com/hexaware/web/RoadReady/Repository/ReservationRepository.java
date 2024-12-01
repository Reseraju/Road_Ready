package com.hexaware.web.RoadReady.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.web.RoadReady.Entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	List<Reservation> findByUser_UserId(int userId);

}