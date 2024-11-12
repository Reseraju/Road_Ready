package com.hexaware.web.RoadReady.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalEceptionController {
	
	@ExceptionHandler(CarNotFoundException.class)
	public ResponseEntity<ErrorDetails> noCarFound(CarNotFoundException ex){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"location not found ","No_Customer_Found");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> r4esourceNotF(ResourceNotFoundException ex){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"location not found ","No_Customer_Found");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UpdateException.class)
	public ResponseEntity<ErrorDetails> updateNotPossible(UpdateException ex){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"location not found ","No_Customer_Found");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
