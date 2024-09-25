package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.DTO.UserDTO;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "APIs related to User operations")
public class UserController {

	@Autowired
	private UserService service;

	@Operation(description = "Create and save a new user", responses = {
			@ApiResponse(description = "Sucess", responseCode = "201"),
			@ApiResponse(description = "Failure", responseCode = "400") })

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<UserDTO>> saveUser(@RequestBody UserDTO user) {
		ResponseStructure<UserDTO> savedUser = service.saveUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@Operation(description = "Update an existing user by ID", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<UserDTO>> updateUser(@PathVariable("id") int id, @RequestBody UserDTO u) {
		ResponseStructure<UserDTO> response = service.updateUser(id, u);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Operation(description = "Retrieve a user by their ID", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchByID/{id}")
	public ResponseEntity<ResponseStructure<UserDTO>> fetchByID(@PathVariable("id") int id) {
		ResponseStructure<UserDTO> response = service.fetchByID(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Operation(description = "Retrieve a user by their email", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchByEmail/{email}")
	public ResponseEntity<ResponseStructure<UserDTO>> fetchByEmail(@PathVariable("email") String email) {
		ResponseStructure<UserDTO> response = service.fetchByEmail(email);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Operation(description = "Retrieve a user by their phone number", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchByNumber/{phoneNo}")
	public ResponseEntity<ResponseStructure<UserDTO>> fetchByNumber(@PathVariable("phoneNo") long phoneNo) {
		ResponseStructure<UserDTO> response = service.fetchByNumber(phoneNo);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Operation(description = "Retrieve a list of users by name", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchByName/{name}")
	public ResponseEntity<ResponseStructure<List<UserDTO>>> fetchByName(@PathVariable("name") String name) {
		ResponseStructure<List<UserDTO>> response = service.fetchByName(name);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Operation(description = "Retrieve a list of all users", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchAllUser")
	public ResponseEntity<ResponseStructure<List<UserDTO>>> fetchAllUser() {
		ResponseStructure<List<UserDTO>> response = service.fetchallUser();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Operation(description = "Check if a user exists by their email", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/existsByEmail/{email}")
	public ResponseEntity<ResponseStructure<Boolean>> existsByEmail(@PathVariable("email") String email) {
		ResponseStructure<Boolean> response = service.existByEmail(email);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Operation(description = "", responses = { @ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/existsByNumber/{phoneNo}")
	public ResponseEntity<ResponseStructure<Boolean>> existsByNumber(@PathVariable("phoneNo") long phoneNo) {
		ResponseStructure<Boolean> response = service.existsByNumber(phoneNo);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Operation(description = "Check if a user exists by their phone number", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@DeleteMapping("/deleteByID/{id}")
	public ResponseEntity<ResponseStructure<UserDTO>> deleteByID(@PathVariable("id") int id) {
		ResponseStructure<UserDTO> response = service.deleteByID(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Operation(description = "", responses = { @ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@DeleteMapping("/deleteByNumber/{phoneNo}")
	public ResponseEntity<ResponseStructure<UserDTO>> deleteByNumber(@PathVariable("phoneNo") long phoneNo) {
		ResponseStructure<UserDTO> response = service.deleteByPhoneNo(phoneNo);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
