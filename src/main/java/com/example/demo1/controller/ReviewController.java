package com.example.demo1.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.DTO.ReviewDTO;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.service.ReviewService;

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
@RequestMapping("/Review")
@Tag(name = "Review", description = "APIs related to Review operations")
public class ReviewController {
	@Autowired
	private ReviewService service;

	@Operation(description = "Create and save a new review", responses = {
			@ApiResponse(description = "Sucess", responseCode = "201"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@PostMapping("/saveReview")
	public ResponseEntity<ResponseStructure<ReviewDTO>> saveReview(@RequestBody ReviewDTO r) {
		ResponseStructure<ReviewDTO> structure = service.saveReview(r);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Update an existing review by its ID", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<ReviewDTO>> updateReview(@PathVariable("id") int id,
			@RequestBody ReviewDTO r) {
		ResponseStructure<ReviewDTO> structure = service.updateReview(id, r);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Retrieve a review by its ID", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchByid/{id}")
	public ResponseEntity<ResponseStructure<ReviewDTO>> fetchById(@PathVariable("id") int id) {
		ResponseStructure<ReviewDTO> structure = service.fetchById(id);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Retrieve a list of reviews by rating", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchByRating/{rating}")
	public ResponseEntity<ResponseStructure<List<ReviewDTO>>> fetchByRating(@PathVariable("rating") int rating) {
		ResponseStructure<List<ReviewDTO>> structure = service.fetchByRating(rating);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Retrieve a list of reviews by review date", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchByReviewDate/{reviewDate}")
	public ResponseEntity<ResponseStructure<List<ReviewDTO>>> fetchByReviewDate(
			@PathVariable("reviewDate") Date reviewDate) {
		ResponseStructure<List<ReviewDTO>> structure = service.fetchByReviewDate(reviewDate);
		return new ResponseEntity<>(structure, HttpStatus.OK);

	}

	@Operation(description = "Retrieve a list of reviews by user phone number", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchByphoneNumber/{phoneNo}")
	public ResponseEntity<ResponseStructure<List<ReviewDTO>>> fetchByPhoneNo(@PathVariable("phoneNo") long phoneNo) {
		ResponseStructure<List<ReviewDTO>> structure = service.fetchByPhoneNo(phoneNo);
		return new ResponseEntity<>(structure, HttpStatus.OK);

	}

	@Operation(description = "Delete a review by its ID", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@DeleteMapping("/DeleteById/{id}")
	public ResponseEntity<ResponseStructure<ReviewDTO>> deleteById(@PathVariable("id") int id) {
		ResponseStructure<ReviewDTO> structure = service.deleteById(id);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

}
