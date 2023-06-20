package com.olteanuflorin86.msscbeerservicev1.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olteanuflorin86.brewery.model.BeerStyleEnum;
import com.olteanuflorin86.msscbeerservicev1.domain.Beer;

@Repository
public interface BeerRepository extends JpaRepository<Beer, UUID> {

	Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageable);

	Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

	Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);

	Beer findByUpc(String upc);
	
}
