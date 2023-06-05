package com.olteanuflorin86.msscbeerservicev1.services;

import java.util.UUID;   
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.olteanuflorin86.msscbeerservicev1.domain.Beer;
import com.olteanuflorin86.msscbeerservicev1.repositories.BeerRepository;
import com.olteanuflorin86.msscbeerservicev1.web.mappers.BeerMapper;
import com.olteanuflorin86.msscbeerservicev1.web.model.BeerDto;
import com.olteanuflorin86.msscbeerservicev1.web.model.BeerPagedList;
import com.olteanuflorin86.msscbeerservicev1.web.model.BeerStyleEnum;

import org.springframework.util.StringUtils;

import com.olteanuflorin86.msscbeerservicev1.web.controller.NotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
	
	private final BeerRepository beerRepository;
	private final BeerMapper beerMapper;

	@Cacheable(cacheNames = "beerListCache", condition = "#showInventoryOnHand == false")
	@Override
	public BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand) {

		BeerPagedList beerPagedList;
		Page<Beer> beerPage;
		
		System.out.println("listBeers caching is called");
		
		if(!StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)) {
			// search both
			beerPage = beerRepository.findAllByBeerNameAndBeerStyle(beerName, beerStyle, pageRequest);
		} else if (!StringUtils.isEmpty(beerName) && StringUtils.isEmpty(beerStyle)) {
			// search beer_service name
			beerPage = beerRepository.findAllByBeerName(beerName, pageRequest);
		} else if (StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)) {
			// search beer_service style
			beerPage = beerRepository.findAllByBeerStyle(beerStyle, pageRequest);
		} else {
			beerPage = beerRepository.findAll(pageRequest);
		}
		
		if(showInventoryOnHand) {
		beerPagedList = new BeerPagedList(beerPage
				.getContent()
				.stream()
				.map(beerMapper::beerToBeerDtoWithInventory)
				.collect(Collectors.toList()),
				PageRequest
						.of(beerPage.getPageable().getPageNumber(),
								beerPage.getPageable().getPageSize()),
				beerPage.getTotalElements());
		} else {
			beerPagedList = new BeerPagedList(beerPage
					.getContent()
					.stream()
					.map(beerMapper::beerToBeerDto)
					.collect(Collectors.toList()),
					PageRequest
							.of(beerPage.getPageable().getPageNumber(),
									beerPage.getPageable().getPageSize()),
					beerPage.getTotalElements());
		}

		return beerPagedList;
	}

	@Cacheable(cacheNames = "beerCache", key = "#beerId", condition = "#showInventoryOnHand == false")	
	@Override
	public BeerDto getById(UUID beerId, Boolean showInventoryOnHand) {
		
		System.out.println("getById caching is called");
		
		if(showInventoryOnHand) {
			return beerMapper.beerToBeerDtoWithInventory(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
		} else {
			return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
		}

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
