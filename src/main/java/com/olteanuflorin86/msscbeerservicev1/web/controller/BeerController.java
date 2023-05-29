package com.olteanuflorin86.msscbeerservicev1.web.controller;

import java.util.List;
import java.util.UUID;  

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.olteanuflorin86.msscbeerservicev1.services.BeerService;
import com.olteanuflorin86.msscbeerservicev1.web.model.BeerDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	
	private final BeerService beerService;
	
	@GetMapping
	public ResponseEntity<List<BeerDto>> getAllBeers() {
		return new ResponseEntity<>(beerService.getBeers(), HttpStatus.OK);
	}
	
	@GetMapping("/{beerId}")	
	public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
		
		return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BeerDto> saveNewBeer(@RequestBody @Validated BeerDto beerDto) {

		return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId") UUID beerId, @Validated @RequestBody BeerDto beerDto) {
		
		return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto),HttpStatus.NO_CONTENT);
	}
	
}
