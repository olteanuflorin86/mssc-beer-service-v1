package com.olteanuflorin86.msscbeerservicev1.web.mappers;

import org.springframework.beans.factory.annotation.Autowired; 

import com.olteanuflorin86.msscbeerservicev1.domain.Beer;
import com.olteanuflorin86.msscbeerservicev1.services.inventory.BeerInventoryService;
import com.olteanuflorin86.msscbeerservicev1.web.model.BeerDto;

public abstract class BeerMapperDecorator implements BeerMapper {

	private BeerInventoryService beerInventoryService;
	private BeerMapper mapper;
	
	@Autowired
	public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
		this.beerInventoryService = beerInventoryService;
	}
	
	@Autowired
	public void setMapper(BeerMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public BeerDto beerToBeerDto(Beer beer) {
		BeerDto dto = mapper.beerToBeerDto(beer);
		dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
		System.out.println(dto);
		return dto;
	}

	@Override
	public  Beer beerDtoToBeer(BeerDto dto) {
		return mapper.beerDtoToBeer(dto);
	}
	
}
