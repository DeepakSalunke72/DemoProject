package com.example.demo.dto;

import lombok.Data;

@Data
public class AddressDto {

	private long addressId;
	
	private String addressType;
	
	private String addressLine1; 
	
	private String addressLine2;
	
	private String city;
	
	private String state;
	
	private String country;
}
