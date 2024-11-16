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
	
	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotSavedException.class)
    public ResponseEntity<String> handleUserNotSavedException(UserNotSavedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<String> handleReservationNotFoundException(ReservationNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReservationNotSavedException.class)
    public ResponseEntity<String> handleReservationNotSavedException(ReservationNotSavedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
