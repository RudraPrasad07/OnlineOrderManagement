package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.DTO.CartDTO;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.service.CartService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/Cart")
@Tag(name = "Cart",description = "Operations related to managing user Cart Details")
public class CartController {
	@Autowired
	private CartService service;

	@Operation(description = "Retrieves cart details by cart ID.Returns the Cart details if found", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchCartById/{id}")
	public ResponseEntity<ResponseStructure<CartDTO>> fetchCartById(@PathVariable("id") int id) {
		ResponseStructure<CartDTO> structure = service.fetchCartById(id);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Adds a product to the cart with specified quantity", responses = {
			@ApiResponse(description = "Sucess", responseCode = "201"),
			@ApiResponse(description = "Failure", responseCode = "409") })
	@PostMapping("/{cartId}/product/{productId}/stockQuantity/{stockQuantity}")
	public ResponseEntity<ResponseStructure<CartDTO>> addProduct(@PathVariable("cartId") int cartId,
			@PathVariable("productId") int productId, @PathVariable("stockQuantity") int stockQuantity) {
		ResponseStructure<CartDTO> structure = service.addProduct(cartId, productId, stockQuantity);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Removes a product from the cart by product ID", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "404") })
	@DeleteMapping("/{cId}/product/{pId}")
	public ResponseEntity<ResponseStructure<CartDTO>> removeProduct(@PathVariable("cId") int cId,
			@PathVariable("pId") int pId) {
		ResponseStructure<CartDTO> structure = service.removeProduct(cId, pId);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Retrieves all carts from the Database", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "404") })
	@GetMapping("/fetchAllcart")
	public ResponseEntity<ResponseStructure<List<CartDTO>>> fetchAllCart() {
		ResponseStructure<List<CartDTO>> structure = service.fetchAllCart();
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Verifies if a product exists in a cart with the specified quantity", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "404") })
	@GetMapping("/productexistsinCart/{cartId}/{productId}/stockQuanty/{stockQuanty}")
	public ResponseEntity<ResponseStructure<Boolean>> productexistsinCart(@PathVariable("cartId") int cartId,
			@PathVariable("productId") int productId, @PathVariable("stockQuanty") int stockQuanty) {
		ResponseStructure<Boolean> structure = service.productexistsinCart(cartId, productId, stockQuanty);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Updates the quantity of a product in the cart", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "404") })
	@PutMapping("/{cartId}/product/{productId}/stockQuanty/{stockQuanty}")
	public ResponseEntity<ResponseStructure<CartDTO>> updateProductQuentity(@PathVariable("cartId") int cartId,
			@PathVariable("productId") int productId, @PathVariable("stockQuanty") int stockQuanty) {
		ResponseStructure<CartDTO> structure = service.updateProductQuentity(cartId, productId, stockQuanty);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Fetches the total product count in the cart by cart ID", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "404") })
	@GetMapping("/fetchCountByCartId/{cartId}")
	public ResponseEntity<ResponseStructure<CartDTO>> FetchCountByCartId(@PathVariable("cartId") int cartId) {
		ResponseStructure<CartDTO> structure = service.FetchCountByCartId(cartId);
		return new ResponseEntity<>(structure, HttpStatus.OK);

	}

}
