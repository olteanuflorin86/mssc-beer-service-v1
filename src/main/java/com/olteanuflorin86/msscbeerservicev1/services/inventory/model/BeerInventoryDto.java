package com.olteanuflorin86.msscbeerservicev1.services.inventory.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerInventoryDto {

	private UUID id;
	private OffsetDateTime createdDate;
	private OffsetDateTime lastModifiedDate;
	private UUID beerId;
	private Integer quantifyOnHand;
}
