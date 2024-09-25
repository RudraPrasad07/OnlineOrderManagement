package com.example.demo1.dao;

import java.util.List;

import com.example.demo1.DTO.CartDTO;

public interface CartDao {

	CartDTO fetchCartById(int id);

	CartDTO addProduct(int cartId, int productId, int stockQuantity);

	CartDTO removeProduct(int cId, int pId);

	List<CartDTO> fetchAllCart();

	Boolean productexistsinCart(int cartId, int productId, int stockQuanty);

	CartDTO updateProductQuentity(int cartId, int productId, int stockQuanty);

	CartDTO FetchCountByCartId(int cartId);
}
