 package com.olteanuflorin86.msscbeerservicev1.web.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olteanuflorin86.msscbeerservicev1.bootstrap.BeerLoader;
import com.olteanuflorin86.msscbeerservicev1.services.BeerService;
import com.olteanuflorin86.msscbeerservicev1.web.model.BeerDto;
import com.olteanuflorin86.msscbeerservicev1.web.model.BeerStyleEnum;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	BeerService beerService;
	
	@Test
	void getBeerById() throws Exception {
		given(beerService.getById(any())).willReturn(getValidBeerDto());
		
		mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	
	@Test
	void saveNewBeer() throws Exception {
		
//		BeerDto beerDto = BeerDto.builder().build();
		BeerDto beerDto = getValidBeerDto();
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);
		
		given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());
		
		mockMvc.perform(post("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
				.andExpect(status().isCreated());
	}
	
	@Test
	void updateBeerById() throws Exception {
		given(beerService.updateBeer(any(), any())).willReturn(getValidBeerDto());
		
//		BeerDto beerDto = BeerDto.builder().build();
		BeerDto beerDto = getValidBeerDto();
		String BeerDtoJson = objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(BeerDtoJson))
				.andExpect(status().isNoContent());
	}
	
	BeerDto getValidBeerDto() {
		return BeerDto.builder()
				.beerName("MyBeer")
				.beerStyle(BeerStyleEnum.ALE)
				.price(new BigDecimal(2.99))
				.upc(BeerLoader.BEER_1_UPC)
				.build();
	}
}







