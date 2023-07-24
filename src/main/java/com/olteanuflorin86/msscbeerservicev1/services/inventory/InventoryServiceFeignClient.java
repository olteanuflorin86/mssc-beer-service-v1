package com.olteanuflorin86.msscbeerservicev1.services.inventory;

import java.util.List; 
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.olteanuflorin86.msscbeerservicev1.services.inventory.model.BeerInventoryDto;

@FeignClient(name = "inventory-service")
public interface InventoryServiceFeignClient {

	@RequestMapping(method = RequestMethod.GET, value = BeerInventoryServiceRestTemplateImpl.INVENTORY_PATH)
	ResponseEntity<List<BeerInventoryDto>> getOnhandInventory(@PathVariable UUID beerId);
}
