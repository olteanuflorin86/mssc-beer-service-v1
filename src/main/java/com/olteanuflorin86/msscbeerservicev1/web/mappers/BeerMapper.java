package com.olteanuflorin86.msscbeerservicev1.web.mappers;

import org.mapstruct.DecoratedWith;   
import org.mapstruct.Mapper;

import com.olteanuflorin86.brewery.model.BeerDto;
import com.olteanuflorin86.msscbeerservicev1.domain.Beer;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
	
	BeerDto beerToBeerDto(Beer beer);
	
	BeerDto beerToBeerDtoWithInventory(Beer beer);

	Beer beerDtoToBeer(BeerDto dto);
	
}
