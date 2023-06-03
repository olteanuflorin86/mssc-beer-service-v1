package com.olteanuflorin86.msscbeerservicev1.services;

import java.util.UUID;

import org.springframework.data.domain.PageRequest;

import com.olteanuflorin86.msscbeerservicev1.web.model.BeerDto;
import com.olteanuflorin86.msscbeerservicev1.web.model.BeerPagedList;
import com.olteanuflorin86.msscbeerservicev1.web.model.BeerStyleEnum;

public interface BeerService {

	BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);

	BeerDto getById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto updateBeer(UUID beerId, BeerDto beerDto);

	
}
