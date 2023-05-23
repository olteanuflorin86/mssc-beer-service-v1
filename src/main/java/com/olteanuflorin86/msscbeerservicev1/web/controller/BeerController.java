package com.olteanuflorin86.msscbeerservicev1.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.olteanuflorin86.msscbeerservicev1.web.model.BeerDto;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

	@GetMapping("/{beerId}")	
	public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
		
		// TO DO the implementation
		return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity saveNewBeer(@Validated @RequestBody BeerDto beerDto) {
		
		// TO DO the implementation
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity updateBeerById(@PathVariable("beerId") UUID BeerId, @Validated @RequestBody BeerDto beerDto) {
		
		// TO DO the implementation
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
}
