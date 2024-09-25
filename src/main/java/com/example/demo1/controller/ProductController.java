package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.DTO.ProductDTO;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/Product")
@Tag(name = "Product", description = "APIs related to Product operations")
public class ProductController {
	@Autowired
	private ProductService service;

	@Operation(description = "Create and save a new product", responses = {
			@ApiResponse(description = "Sucess", responseCode = "201"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@PostMapping("/saveProduct")
	public ResponseEntity<ResponseStructure<ProductDTO>> saveProduct(@RequestBody ProductDTO p) {
		ResponseStructure<ProductDTO> structure = service.saveProduct(p);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Update an existing product by its ID", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<ResponseStructure<ProductDTO>> updateProduct(@PathVariable("id") int id,
			@RequestBody ProductDTO p) {
		ResponseStructure<ProductDTO> structure = service.updateProduct(id, p);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Retrieve product details by ID", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchByid/{id}")
	public ResponseEntity<ResponseStructure<ProductDTO>> fetchByid(@PathVariable("id") int id) {
		ResponseStructure<ProductDTO> structure = service.fetchByid(id);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Retrieve a list of products by name", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchByName/{name}")
	public ResponseEntity<ResponseStructure<List<ProductDTO>>> fetchByName(@PathVariable("name") String name) {
		ResponseStructure<List<ProductDTO>> structure = service.fetchByName(name);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Retrieve a list of products by price", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchByPrice/{Price}")
	public ResponseEntity<ResponseStructure<List<ProductDTO>>> fetchByPrice(@PathVariable("Price") double Price) {
		ResponseStructure<List<ProductDTO>> structure = service.fetchByPrice(Price);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Retrieve a list of products by stock quantity", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchBystockQuanty/{stockQuanty}")
	public ResponseEntity<ResponseStructure<List<ProductDTO>>> fetchBystockQuanty(
			@PathVariable("stockQuanty") int stockQuanty) {
		ResponseStructure<List<ProductDTO>> structure = service.fetchBystockQuanty(stockQuanty);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Retrieve a list of products by category", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchBycategory/{category}")
	public ResponseEntity<ResponseStructure<List<ProductDTO>>> fetchBycategory(
			@PathVariable("category") String category) {
		ResponseStructure<List<ProductDTO>> structure = service.fetchBycategory(category);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Retrieve all products", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<ProductDTO>>> fetchAllProduct() {
		ResponseStructure<List<ProductDTO>> structure = service.fetchAllProduct();
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Delete a product by its ID", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@DeleteMapping("/deleteByid/{id}")
	public ResponseEntity<ResponseStructure<ProductDTO>> deleteByid(@PathVariable("id") int id) {
		ResponseStructure<ProductDTO> structure = service.deleteByid(id);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
}
