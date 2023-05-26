package com.olteanuflorin86.msscbeerservicev1.services;

import java.util.UUID; 

import org.springframework.stereotype.Service;

import com.olteanuflorin86.msscbeerservicev1.domain.Beer;
import com.olteanuflorin86.msscbeerservicev1.repositories.BeerRepository;
import com.olteanuflorin86.msscbeerservicev1.web.mappers.BeerMapper;
import com.olteanuflorin86.msscbeerservicev1.web.model.BeerDto;
import com.olteanuflorin86.msscbeerservicev1.web.controller.NotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
	
	private final BeerRepository beerRepository;
	private final BeerMapper beerMapper;

	@Override
	public BeerDto getById(UUID beerId) {
		return beerMapper.beerToBeerDto(
				beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
		);
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
	}

	@Override
	public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
		Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
		
		beer.setBeerName(beerDto.getBeerName());
		beer.setBeerStyle(beerDto.getBeerStyle().name());
		beer.setPrice(beerDto.getPrice());
		beer.setUpc(beerDto.getUpc());
		
		return beerMapper.beerToBeerDto(beerRepository.save(beer));
	}

}
