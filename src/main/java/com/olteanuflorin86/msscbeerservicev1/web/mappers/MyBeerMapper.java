package com.olteanuflorin86.msscbeerservicev1.web.mappers;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component;

import com.olteanuflorin86.brewery.model.BeerDto;
import com.olteanuflorin86.brewery.model.BeerStyleEnum;
import com.olteanuflorin86.brewery.model.BeerDto.BeerDtoBuilder;
import com.olteanuflorin86.msscbeerservicev1.domain.Beer;
import com.olteanuflorin86.msscbeerservicev1.domain.Beer.BeerBuilder;
import com.olteanuflorin86.msscbeerservicev1.services.inventory.BeerInventoryService;

@Component
public class MyBeerMapper {
	
	private BeerInventoryService beerInventoryService;
	
	@Autowired
	public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
		this.beerInventoryService = beerInventoryService;
	}
	
	@Autowired
    private DateMapper dateMapper;
	
	public BeerDto beerToBeerDto(Beer beer) {
		if ( beer == null ) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        beerDto.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.beerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDto.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.id( beer.getId() );
        beerDto.lastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );
        beerDto.price( beer.getPrice() );
        beerDto.upc( beer.getUpc() );
        if ( beer.getVersion() != null ) {
            beerDto.version( beer.getVersion().intValue() );
        }

        return beerDto.build();
	}
	
	public BeerDto beerToBeerDtoWithInventory(Beer beer) {
		BeerDto dto = beerToBeerDto(beer);
		dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
		//System.out.println(dto);
		return dto;
	}

	public Beer beerDtoToBeer(BeerDto dto) {
		if ( dto == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.beerName( dto.getBeerName() );
        if ( dto.getBeerStyle() != null ) {
            beer.beerStyle( dto.getBeerStyle().name() );
        }
        beer.createdDate( dateMapper.asTimestamp( dto.getCreatedDate() ) );
        beer.id( dto.getId() );
        beer.lastModifiedDate( dateMapper.asTimestamp( dto.getLastModifiedDate() ) );
        beer.price( dto.getPrice() );
        beer.upc( dto.getUpc() );
        if ( dto.getVersion() != null ) {
            beer.version( dto.getVersion().longValue() );
        }

        return beer.build();
	}
	
}
