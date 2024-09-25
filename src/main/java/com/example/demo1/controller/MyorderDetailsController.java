package com.example.demo1.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.DTO.MyorderDetailsDTO;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.service.MyorderDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/Myorder")
@Tag(name = "MyOrder", description = "Manage and retrieve order details")
public class MyorderDetailsController {
	@Autowired
	private MyorderDetailsService service;

	@Operation(description = "This endpoint allows the creation of a new order associated with a specific user. It accepts order details and the user ID, returning the newly created order.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "201"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@PostMapping("/createOrder/{userID}")
	public ResponseEntity<ResponseStructure<MyorderDetailsDTO>> createOrder(@RequestBody MyorderDetailsDTO details,
			@PathVariable("userID") int userID) {
		ResponseStructure<MyorderDetailsDTO> structure = service.createOrder(details, userID);
		return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}

	@Operation(description = "Fetch all the orders from the database.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/getAllOrder")
	public ResponseEntity<ResponseStructure<List<MyorderDetailsDTO>>> getAllOrder() {
		ResponseStructure<List<MyorderDetailsDTO>> structure = service.getAllOrder();
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Fetch a specific order by its unique ID.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/getOrderById/{Id}")
	public ResponseEntity<ResponseStructure<MyorderDetailsDTO>> getOrderById(@PathVariable("Id") int Id) {
		ResponseStructure<MyorderDetailsDTO> structure = service.getOrderById(Id);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Update the details of an existing order by providing the order ID and new order data.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@PutMapping("/UpdateOrder/{id}")
	public ResponseEntity<ResponseStructure<MyorderDetailsDTO>> UpdateOrderId(@PathVariable("id") int id,
			@RequestBody MyorderDetailsDTO details) {
		ResponseStructure<MyorderDetailsDTO> structure = service.UpdateOrderId(id, details);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Delete an order from the database by its ID.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@DeleteMapping("/DeleteOrderById/{id}")
	public ResponseEntity<ResponseStructure<MyorderDetailsDTO>> deleteOrderById(@PathVariable("id") int id) {
		ResponseStructure<MyorderDetailsDTO> structure = service.deleteOrderById(id);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Fetch all orders that use a specific shipping method.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/getOrderByshippingMethod/{shippingMethod}")
	public ResponseEntity<ResponseStructure<List<MyorderDetailsDTO>>> getOrderByshippingMethod(
			@PathVariable("shippingMethod") String shippingMethod) {
		ResponseStructure<List<MyorderDetailsDTO>> structure = service.getOrderByshippingMethod(shippingMethod);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Fetch all orders that use a specific payment method.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/getOrderBypaymentMethod/{paymentMethod}")
	public ResponseEntity<ResponseStructure<List<MyorderDetailsDTO>>> getOrderBypaymentMethod(
			@PathVariable("paymentMethod") String paymentMethod) {
		ResponseStructure<List<MyorderDetailsDTO>> structure = service.getOrderBypaymentMethod(paymentMethod);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Fetch a specific order by its tracking number.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/getOrderByTrackingNumber/{TrackingNumber}")
	public ResponseEntity<ResponseStructure<MyorderDetailsDTO>> getOrderByTrackingNumber(
			@PathVariable("TrackingNumber") String TrackingNumber) {
		ResponseStructure<MyorderDetailsDTO> structure = service.getOrderByTrackingNumber(TrackingNumber);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Fetch all orders that are expected to be delivered on a specific date.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/getOrderByDeliveryDate/{DeliveryDate}")
	public ResponseEntity<ResponseStructure<List<MyorderDetailsDTO>>> getOrderByDeliveryDate(
			@PathVariable("DeliveryDate") LocalDateTime expectedDeliveryDate) {
		ResponseStructure<List<MyorderDetailsDTO>> structure = service.getOrderByDeliveryDate(expectedDeliveryDate);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
}
