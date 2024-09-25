package com.example.demo1.service;

import java.util.List;

import com.example.demo1.DTO.CartDTO;
import com.example.demo1.Utility.ResponseStructure;

public interface CartService {
	ResponseStructure<CartDTO> fetchCartById(int id);

	ResponseStructure<CartDTO> addProduct(int cartId, int productId, int stockQuantity);

	ResponseStructure<CartDTO> removeProduct(int cId, int pId);

	ResponseStructure<List<CartDTO>> fetchAllCart();

	ResponseStructure<CartDTO> updateProductQuentity(int cartId, int productId, int stockQuanty);

	ResponseStructure<Boolean> productexistsinCart(int cartId, int productId, int stockQuanty);

	ResponseStructure<CartDTO> FetchCountByCartId(int cartId);

}
