//package com.olteanuflorin86.msscbeerservicev1.services.inventory; 
//
//import org.junit.jupiter.api.BeforeEach;  
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.olteanuflorin86.msscbeerservicev1.bootstrap.BeerLoader;
//
////@Disabled // utility for manual testing
//@SpringBootTest
//class BeerInventoryServiceRestTemplateImplTest {
//
//	@Autowired
//	BeerInventoryService beerInventoryService;
//	
//	@BeforeEach
//	void setup() {
//		
//	}
//	
//	@Test
//	void getOnhandInventory() {
//		// todo evolve to UPC
//		Integer qoh = beerInventoryService.getOnhandInventory(BeerLoader.BEER_1_UUID);
//	
//		System.out.println(qoh);
//	}
//}

package com.olteanuflorin86.msscbeerservicev1.services.inventory;

import org.junit.jupiter.api.BeforeEach;   
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.olteanuflorin86.msscbeerservicev1.bootstrap.BeerLoader;

//@Disabled // utility for manual testing
@SpringBootTest
class BeerInventoryServiceRestTemplateImplTest {

	@Autowired
	BeerInventoryService beerInventoryService;
	
	@BeforeEach
	void setup() {
		
	}
	
	@Test
	void getOnhandInventory() {
		// todo evolve to UPC
//		Integer qoh = beerInventoryService.getOnhandInventory(BeerLoader.BEER_1_UUID);
	
//		System.out.println(qoh);
	}
}



