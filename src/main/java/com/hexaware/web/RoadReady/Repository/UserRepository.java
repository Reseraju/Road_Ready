package com.hexaware.web.RoadReady.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.web.RoadReady.Entity.User;
import com.hexaware.web.RoadReady.enums.UserType;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	User findByUsername(String username);
	
	User findByEmail(String email);
	
	Optional<User> findFirstByEmail(String email);
	
	User findByUserType(UserType userType);
	
	@Query("SELECT COUNT(u) FROM User u")
	long countTotalUsers();
}
