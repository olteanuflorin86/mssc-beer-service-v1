package com.olteanuflorin86.msscbeerservicev1.services.inventory;

import java.util.UUID;

public interface BeerInventoryService {

	Integer getOnhandInventory(UUID beerId);
}
