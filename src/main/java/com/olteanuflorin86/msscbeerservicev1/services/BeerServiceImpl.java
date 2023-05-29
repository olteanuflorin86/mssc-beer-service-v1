package com.olteanuflorin86.msscbeerservicev1.services;

import java.util.ArrayList;
import java.util.List;
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
	public List<BeerDto> getBeers() {
		Iterable<Beer> beerIterable = beerRepository.findAll(); 
		List<Beer> beerList = new ArrayList<>();
		List<BeerDto> beerDtoList = new ArrayList<>();
		beerIterable.forEach(beerList::add);
		beerList.forEach(beer -> {
			beerDtoList.add(beerMapper.beerToBeerDto(beer));
		});
		return beerDtoList;
	}
	
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
