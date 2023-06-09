package com.olteanuflorin86.brewery.model.events;

import java.io.Serializable;

import com.olteanuflorin86.brewery.model.BeerDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerEvent implements Serializable {

	private static final long serialVersionUID = 1412044055675622761L;
	
	private BeerDto beerDto;
}
