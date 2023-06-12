package com.olteanuflorin86.msscbeerservicev1.events;

import com.olteanuflorin86.msscbeerservicev1.web.model.BeerDto;

public class BrewBeerEvent extends BeerEvent {

	public BrewBeerEvent(BeerDto beerDto) {
		super(beerDto);
	}

}
