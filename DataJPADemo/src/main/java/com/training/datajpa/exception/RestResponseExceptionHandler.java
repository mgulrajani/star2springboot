package com.training.datajpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice  //this advice will be shared all controllers will share it
//all exceptions can be handled here

public class RestResponseExceptionHandler  extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(CarIdNotFoundException.class)
	public ResponseEntity<ErrorMessage>  carNotFound(CarIdNotFoundException cnf , WebRequest req){
		
		
		ErrorMessage em = new  ErrorMessage(HttpStatus.NOT_FOUND ,cnf.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
		

	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleAnyException( BadRequestException brreq,WebRequest request){
	
		ErrorMessage em = new ErrorMessage(HttpStatus.BAD_REQUEST,"Bad Request");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(em);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorMessage> handleAnyException1(Exception e){
		ErrorMessage em = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR,"Data is null");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(em);
	}
	
	
  
}


