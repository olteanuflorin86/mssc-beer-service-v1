package com.olteanuflorin86.msscbeerservicev1.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e) {
		List<String> errorsList = new ArrayList<>(e.getConstraintViolations().size());
		
		e.getConstraintViolations().forEach(error -> errorsList.add(error.toString()));
		
		return new ResponseEntity<>(errorsList, HttpStatus.BAD_REQUEST);
	}
	
}
