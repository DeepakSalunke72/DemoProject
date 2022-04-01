package com.example.demo.service;

import com.example.demo.entity.Address;

public interface AddressService {

	public Address getAddressById(long addressId);
	
	public Address updateAddress(Address address);

	public void deleteAddressById(long addressId);
	
}
