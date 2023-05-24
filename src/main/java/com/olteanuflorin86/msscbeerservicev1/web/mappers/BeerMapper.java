package com.olteanuflorin86.msscbeerservicev1.web.mappers;

import org.mapstruct.Mapper;

import com.olteanuflorin86.msscbeerservicev1.domain.Beer;
import com.olteanuflorin86.msscbeerservicev1.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
	
	BeerDto beerToBeerDto(Beer beer);

	Beer beerDtoToBeer(BeerDto dto);
	
}
