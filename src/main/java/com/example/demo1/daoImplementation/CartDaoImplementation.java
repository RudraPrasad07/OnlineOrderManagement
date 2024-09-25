package com.example.demo1.daoImplementation;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.DTO.CartDTO;
import com.example.demo1.DTO.ProductDTO;
import com.example.demo1.Entity.Cart;
import com.example.demo1.Entity.Product;
import com.example.demo1.Exception.EntityNotPresentException;
import com.example.demo1.Exception.StockQuentityExceedException;
import com.example.demo1.Repositry.CartRepositry;
import com.example.demo1.Repositry.ProductRepositry;
import com.example.demo1.dao.CartDao;

import jakarta.transaction.Transactional;

@Repository
public class CartDaoImplementation implements CartDao {
	@Autowired
	private CartRepositry repositry;
	@Autowired
	private ProductRepositry productRepositry;
	@Autowired
	private ProductDaoImplementation dao;

	@Override
	public CartDTO fetchCartById(int id) {
		Cart cart = repositry.findById(id)
				.orElseThrow(() -> new EntityNotPresentException("Entity Not Present With The id " + id));
		return mapToDTO(cart);
	}

	@Override
	@Transactional
	public CartDTO addProduct(int cartId, int productId, int stockQuantity) {
		Cart cart = repositry.findById(cartId).orElseThrow(
				() -> new EntityNotPresentException("Cart with ID " + cartId + " is not present in the Database"));

		Product product = productRepositry.findById(productId).orElseThrow(() -> new EntityNotPresentException(
				"Product with ID " + productId + " is not present in the Database"));

		if (stockQuantity > product.getStockQuanty()) {
			throw new StockQuentityExceedException("Requested stock quantity " + stockQuantity
					+ " exceeds available stock " + product.getStockQuanty());
		}

		boolean productExists = cart.getProducts() != null
				&& cart.getProducts().stream().anyMatch(p -> p.getId() == productId);

		if (productExists) {
			throw new EntityNotPresentException("Product is already present in the cart");
		}

		if (cart.getProducts() == null) {
			cart.setProducts(new ArrayList<>());
		}
		cart.getProducts().add(product);
		cart.setProductCount(cart.getProducts().size());

		double newTotalPrice = cart.getTotalprice() + (product.getPrice() * stockQuantity);
		cart.setTotalprice(newTotalPrice);
		cart.setStockQuentity(stockQuantity);
		product.setStockQuanty(product.getStockQuanty() - stockQuantity);
		productRepositry.save(product);

		return mapToDTO(repositry.save(cart));
	}

	@Override
	@Transactional
	public CartDTO removeProduct(int cId, int pId) {
		Cart cart = repositry.findById(cId)
				.orElseThrow(() -> new EntityNotPresentException("CartId " + cId + " not present in the database"));

		Product product = productRepositry.findById(pId)
				.orElseThrow(() -> new EntityNotPresentException("ProductId " + pId + " not present in the database"));

		boolean productRemoved = cart.getProducts() != null && cart.getProducts().removeIf(p -> p.getId() == pId);

		if (!productRemoved) {
			throw new EntityNotPresentException("Product not found in the cart. Please check the ProductId.");
		}

		if (cart.getProducts().isEmpty()) {
			cart.setTotalprice(0);
		} else {
			double newTotalPrice = cart.getTotalprice() - product.getPrice();
			cart.setTotalprice(Math.max(0, Math.round(newTotalPrice * 100.0) / 100.0)); // rounding to 2 decimal places
		}

		product.setStockQuanty(product.getStockQuanty() + cart.getStockQuentity());
		productRepositry.save(product);

		cart.setProductCount(cart.getProducts().size());
		cart.setStockQuentity(0);

		return mapToDTO(repositry.save(cart));
	}

	@Override
	public List<CartDTO> fetchAllCart() {
		List<Cart> carts = repositry.findAll();
		List<CartDTO> cartDTOs = new ArrayList<>();
		for (Cart cart : carts) {
			cartDTOs.add(mapToDTO(cart));
		}
		return cartDTOs;
	}

	@Override
	public Boolean productexistsinCart(int cartId, int productId, int stockQuanty) {
		CartDTO cart = fetchCartById(cartId);
		dao.fetchByid(productId);
		return cart.getProducts().stream()
				.anyMatch(product -> product.getId() == productId && product.getStockQuanty() >= stockQuanty);
	}

	@Override
	public CartDTO FetchCountByCartId(int cartId) {
		Cart cart = repositry.findById(cartId)
				.orElseThrow(() -> new EntityNotPresentException("Entity Not Present With The id " + cartId));
		cart.setProductCount(cart.getProducts().size());
		return mapToDTO(repositry.save(cart));
	}

	@Override
	public CartDTO updateProductQuentity(int cartId, int productId, int stockQuanty) {
		Cart cart = repositry.findById(cartId)
				.orElseThrow(() -> new EntityNotPresentException("Entity Not Present With The id " + cartId));
		ProductDTO product = dao.fetchByid(productId);

		if (stockQuanty > product.getStockQuanty()) {
			throw new StockQuentityExceedException("The Given Stock Quantity " + stockQuanty
					+ " exceeds the Actual Stock Quantity " + product.getStockQuanty());
		}

		return mapToDTO(repositry.save(cart));
	}

	private Cart mapToEntity(CartDTO dto) {
		Cart cart = new Cart();
		cart.setId(dto.getId());
		cart.setProductCount(dto.getProductCount());
		cart.setProducts(dto.getProducts());
		cart.setStockQuentity(dto.getStockQuentity());
		cart.setTotalprice(dto.getTotalprice());

		return cart;
	}

	private CartDTO mapToDTO(Cart cart) {
		CartDTO dto = new CartDTO();
		dto.setId(cart.getId());
		dto.setProductCount(cart.getProductCount());
		dto.setProducts(cart.getProducts());
		dto.setStockQuentity(cart.getStockQuentity());
		dto.setTotalprice(cart.getTotalprice());
		return dto;
	}
}
