package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;	
	
	// get address by addressId
	@Override
	public Address getAddressById(long addressId) {	
		return addressRepository.findById(addressId)
				.orElseThrow(()-> new ResourceNotFound("employeeId not exist with given id :"+ addressId));
	}

	@Override
	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public void deleteAddressById(long addressId) {
		addressRepository.deleteById(addressId);
	}

}