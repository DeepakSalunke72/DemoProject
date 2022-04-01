package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AddressService;
import com.example.demo.dto.AddressDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Department;

@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@Autowired
	private ModelMapper modelMapper;

	//	// get address by addressId
	//	@GetMapping("/address/{addressId}")
	//	public ResponseEntity<Address> getAddressById(@PathVariable long addressId){
	//		return new ResponseEntity<Address>(addressService.getAddressById(addressId), HttpStatus.OK);
	//	}

	// get address by addressId by DTO logic
	@GetMapping("/address/{addressId}")
	public ResponseEntity<AddressDto> getAddressById(@PathVariable long addressId){
		Address address=addressService.getAddressById(addressId);

		// convert entity to DTO
		AddressDto addressDto=modelMapper.map(address, AddressDto.class);

		return ResponseEntity.ok(addressDto);
	}

	//	//update address by addressId
	//	@PutMapping("/address/{addressId}")
	//	public Address updateEmployee(@PathVariable long addressId, @RequestBody Address address) {
	//		return addressService.updateAddress(address);
	//	}

	//update address by addressId by DTO logic
	@PutMapping("/address/{addressId}")
	public ResponseEntity<AddressDto> updateEmployee(@PathVariable long addressId, @RequestBody AddressDto addressDto) {
		//Convert DTO to entity
		Address addressRequest = modelMapper.map(addressDto, Address.class);

		Address address=addressService.updateAddress(addressRequest);

		//Convert entity to DTO
		AddressDto addressResponce=modelMapper.map(addressDto, AddressDto.class);	
		return ResponseEntity.ok().body(addressResponce);
	}
	
	//	//delete address by addressId
	//	@DeleteMapping("/address/{addressId}")
	//	public ResponseEntity<Address> deleteAddressById(@PathVariable long addressId){
	//		return new ResponseEntity<Address>(addressService.deleteAddressById(addressId), HttpStatus.OK);
	//	}
	//	
	
	@DeleteMapping("/address/{addressId}")
	public void deleteAddressById(@PathVariable long addressId) {
		addressService.deleteAddressById(addressId);
	}
	
}

