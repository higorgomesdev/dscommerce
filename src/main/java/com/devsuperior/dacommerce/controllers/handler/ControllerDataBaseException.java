package com.devsuperior.dacommerce.controllers.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dacommerce.DTO.CustomError;
import com.devsuperior.dacommerce.services.exceptions.DataBaseException;
import com.devsuperior.dacommerce.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerDataBaseException {
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<CustomError> resourceNotFound(DataBaseException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(err);
	}

}
