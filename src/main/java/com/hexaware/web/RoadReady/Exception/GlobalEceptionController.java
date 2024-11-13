package com.hexaware.web.RoadReady.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalEceptionController {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> noCarFound(NotFoundException ex){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"location not found ","Car_Not_Found");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NotSavedException.class)
	public ResponseEntity<ErrorDetails> notSavedEx(NotSavedException ex){
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),"location not found ","Not_Saved");
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
