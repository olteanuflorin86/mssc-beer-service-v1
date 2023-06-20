package com.olteanuflorin86.msscbeerservicev1.domain;

import java.math.BigDecimal;  
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity 
public class Beer {

	@Id
	
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type="org.hibernate.type.UUIDCharType")
	@Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
	private UUID id;
	
	@Version
	private Long version;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createdDate;
	
	@UpdateTimestamp
	private Timestamp lastModifiedDate;
	
	private String beerName;
	private String beerStyle;
	
	@Column(unique = true)
	private String upc;
	private BigDecimal price;
	
	private Integer minOnHand; 
	private Integer quantityToBrew;
	@Override
	public String toString() {
		return "Beer [id=" + id + ", version=" + version + ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + ", beerName=" + beerName + ", beerStyle=" + beerStyle + ", upc=" + upc + ", price="
				+ price + ", minOnHand=" + minOnHand + ", quantityToBrew=" + quantityToBrew + "]";
	} 
	
	
}
