package com.olteanuflorin86.msscbeerservicev1.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.olteanuflorin86.msscbeerservicev1.domain.Beer;

@Repository
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
