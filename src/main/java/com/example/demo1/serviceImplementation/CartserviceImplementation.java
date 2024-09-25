package com.example.demo1.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.DTO.CartDTO;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.CartDao;
import com.example.demo1.service.CartService;

@Service
public class CartserviceImplementation implements CartService {
	@Autowired
	private CartDao dao;

	@Override
	public ResponseStructure<CartDTO> fetchCartById(int id) {
		CartDTO cart = dao.fetchCartById(id);
		return new ResponseStructure<CartDTO>(200, "Cart Data Fetched Sucessdully", cart, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<CartDTO> addProduct(int cartId, int productId, int stockQuantity) {
		CartDTO cart = dao.addProduct(cartId, productId, stockQuantity);
		return new ResponseStructure<CartDTO>(201, "Product Added Sucessfully To The Cart", cart, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<CartDTO> removeProduct(int cId, int pId) {
		CartDTO cart = dao.removeProduct(cId, pId);
		return new ResponseStructure<CartDTO>(200, "Product Removed Sucessfully from The cart", cart,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<CartDTO>> fetchAllCart() {
		List<CartDTO> list = dao.fetchAllCart();
		return new ResponseStructure<List<CartDTO>>(200, "All Cart Are Fetched Sucessfully", list, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Boolean> productexistsinCart(int cartId, int productId, int stockQuanty) {
		Boolean cart = dao.productexistsinCart(cartId, productId, stockQuanty);
		return new ResponseStructure<Boolean>(200, "Product Present in the Cart", cart, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<CartDTO> FetchCountByCartId(int cartId) {
		CartDTO cart = dao.fetchCartById(cartId);
		return new ResponseStructure<CartDTO>(cartId, "The Total Count Of The cart Table Is ", cart,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<CartDTO> updateProductQuentity(int cartId, int productId, int stockQuanty) {
		CartDTO cart = dao.updateProductQuentity(cartId, productId, stockQuanty);
		return new ResponseStructure<CartDTO>(200, "The Product Quentiy Updated Sucessfully", cart,
				LocalDateTime.now());
	}
}
