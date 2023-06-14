package com.olteanuflorin86.msscbeerservicev1.events;

import com.olteanuflorin86.msscbeerservicev1.web.model.BeerDto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

	public NewInventoryEvent(BeerDto beerDto) {
		super(beerDto);
	}

}
