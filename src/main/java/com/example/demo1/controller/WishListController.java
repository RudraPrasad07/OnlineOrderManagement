package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.DTO.UserDTO;
import com.example.demo1.DTO.WishListDTO;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.service.WishListService;

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
@RequestMapping("/WishList")
@Tag(name = "WishList",description = "Operations related to managing user WishLists")
public class WishListController {
	@Autowired
	private WishListService service;

	@Operation(summary = "This API updates the Wish List with the provided ID using the information in WishListDTO.", responses = {
			@ApiResponse(description = "Wish list updated successfully", responseCode = "200"),
			@ApiResponse(description = "Failed to update wish list", responseCode = "400") })
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructure<WishListDTO>> updateList(@PathVariable("id") int id,
			@RequestBody WishListDTO wishListDTO) {
		ResponseStructure<WishListDTO> response = service.updateList(id, wishListDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Operation(description = "Retrieves a Wish List by its unique ID passed as a path variable.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/findWishListById/{id}")
	public ResponseEntity<ResponseStructure<WishListDTO>> findWishListByID(@PathVariable("id") int id) {
		ResponseStructure<WishListDTO> structure = service.findWishListByID(id);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "=Retrieves the Wish List associated with a particular user by their email.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/findWishListByUser/{userEmail}")
	public ResponseEntity<ResponseStructure<UserDTO>> findByUserEmail(@PathVariable("userEmail") String email) {
		ResponseStructure<UserDTO> structure = service.findByUserEmail(email);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Adds a product to a Wish List using the provided wishListId and productId.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "201"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@PostMapping("/{wishListId}/product/{productId}")
	public ResponseEntity<ResponseStructure<WishListDTO>> addProductToWishlist(
			@PathVariable("wishListId") int wishListId, @PathVariable("productId") int productId) {
		ResponseStructure<WishListDTO> structure = service.addProduct(wishListId, productId);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@Operation(description = "Removes a product from a Wish List by providing the wishListId and productId.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@DeleteMapping("{lsitId}/Product/{pId}")
	public ResponseEntity<ResponseStructure<WishListDTO>> removeProductfromWishList(@PathVariable("lsitId") int lsitId,
			@PathVariable("pId") int pId) {
		ResponseStructure<WishListDTO> structure = service.removeProduct(lsitId, pId);
		return new ResponseEntity<>(structure, HttpStatus.OK);

	}

	@Operation(description = "Fetches all Wish Lists available inside the DataBase.", responses = {
			@ApiResponse(description = "Sucess", responseCode = "200"),
			@ApiResponse(description = "Failure", responseCode = "400") })
	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<WishListDTO>>> fetchAll() {
		ResponseStructure<List<WishListDTO>> wishListAll = service.findWishListAll();
		return new ResponseEntity<>(wishListAll, HttpStatus.OK);
	}

}
