package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Entity.Address;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.service.AddressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/Address")
@Tag(name = "Address",description = "Operations related to managing user Address")
public class AddressController {
	@Autowired
	private AddressService service;

	@Operation(description = "This endpoint updates the address information based on the provided ID. You need to supply the ID as a path variable and the updated address details as a request body", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "404") })
	@PutMapping("update/{id}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable("id") int id,
			@RequestBody Address a) {
		ResponseStructure<Address> responseStructure = service.updateAddress(id, a);
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
	}

	@Operation(description = " This endpoint retrieves the address information for the given ID. The ID should be provided as a path variable", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "404") })
	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Address>> fetchById(@PathVariable("id") int id) {
		ResponseStructure<Address> responseStructure = service.fetchById(id);
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
	}

}
