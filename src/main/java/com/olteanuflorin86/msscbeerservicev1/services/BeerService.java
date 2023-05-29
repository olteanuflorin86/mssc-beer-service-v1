package com.olteanuflorin86.msscbeerservicev1.services;

import java.util.List;
import java.util.UUID;

import com.olteanuflorin86.msscbeerservicev1.web.model.BeerDto;

public interface BeerService {

	BeerDto getById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto updateBeer(UUID beerId, BeerDto beerDto);

	List<BeerDto> getBeers();
	
}
