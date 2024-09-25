package com.example.demo1.daoImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.DTO.ProductDTO;
import com.example.demo1.DTO.UserDTO;
import com.example.demo1.DTO.WishListDTO;
import com.example.demo1.Entity.Product;
import com.example.demo1.Entity.User;
import com.example.demo1.Entity.WishList;
import com.example.demo1.Exception.EntityNotPresentException;
import com.example.demo1.Repositry.ProductRepositry;
import com.example.demo1.Repositry.UserRepositry;
import com.example.demo1.Repositry.WishListRepositry;
import com.example.demo1.dao.WishListdao;

@Repository
public class WishListDaoImplementation implements WishListdao {

	@Autowired
	private WishListRepositry repositry;

	@Autowired
	private UserRepositry userRepositry;

	@Autowired
	private ProductRepositry productRepositry;

	@Override
	public WishListDTO updateList(int id, WishListDTO w) {
		findWishListByID(id);

		if (w.getUser() == null) {
			throw new EntityNotPresentException("User Not Present");
		}

		if (w.getProducts() == null || w.getProducts().isEmpty()) {
			throw new EntityNotPresentException("Product Entity is not given");
		}

		WishList wishList = mapToEntity(w);
		wishList.setId(id);
		WishList savedWishList = repositry.save(wishList);

		return mapToDTO(savedWishList);
	}

	@Override
	public WishListDTO findWishListByID(int id) {
		Optional<WishList> optional = repositry.findById(id);
		WishList wishList = optional
				.orElseThrow(() -> new EntityNotPresentException("Entity not present with the ID " + id));
		return mapToDTO(wishList);
	}

	@Override
	public UserDTO findByUserEmail(String email) {
		Optional<User> optional = userRepositry.findByEmail(email);
		User user = optional.orElseThrow(() -> new EntityNotPresentException("User not present with email: " + email));
		return mapToDTO(user);
	}

	@Override
	public WishListDTO addProduct(int Id, int productId) {
		Optional<WishList> optional = repositry.findById(Id);
		WishList wishList = optional
				.orElseThrow(() -> new EntityNotPresentException("WishList with ID " + Id + " is not present"));

		Optional<Product> productOptional = productRepositry.findById(productId);
		Product product = productOptional.orElseThrow(() -> new EntityNotPresentException(
				"Product with ID " + productId + " is not present in the database"));

		wishList.getProducts().add(product);
		WishList updatedWishList = repositry.save(wishList);

		return mapToDTO(updatedWishList);
	}

	@Override
	public WishListDTO removeProduct(int Id, int pId) {
		Optional<WishList> optional = repositry.findById(Id);
		WishList wishList = optional
				.orElseThrow(() -> new EntityNotPresentException("WishList with ID " + Id + " is not present"));

		Optional<Product> productOptional = productRepositry.findById(pId);
		Product product = productOptional.orElseThrow(
				() -> new EntityNotPresentException("Product with ID " + pId + " is not present in the database"));

		boolean removed = wishList.getProducts().remove(product);
		if (!removed) {
			throw new EntityNotPresentException("Product not found in the WishList");
		}

		WishList updatedWishList = repositry.save(wishList);
		return mapToDTO(updatedWishList);
	}

	@Override
	public List<WishListDTO> findWishListAll() {
		List<WishList> wishLists = repositry.findAll();
		return wishLists.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	private WishListDTO mapToDTO(WishList wishList) {
		WishListDTO dto = new WishListDTO();
		dto.setId(wishList.getId());
		dto.setUser(mapToDTO(wishList.getUser()));
		dto.setProducts(wishList.getProducts().stream().map(this::mapToDTO).collect(Collectors.toList()));
		return dto;
	}

	private WishList mapToEntity(WishListDTO dto) {
		WishList wishList = new WishList();
		wishList.setId(dto.getId());
		wishList.setUser(mapToEntity(dto.getUser()));
		wishList.setProducts(dto.getProducts().stream().map(this::mapToEntity).collect(Collectors.toList()));
		return wishList;
	}

	private UserDTO mapToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setLastname(user.getLastname());
		dto.setEmail(user.getEmail());
		dto.setPhoneNo(user.getPhoneNo());
		dto.setStatus(user.getStatus());
		dto.setRole(user.getRole());
		dto.setDob(user.getDob());
		dto.setGender(user.getGender());
		return dto;
	}

	private User mapToEntity(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setLastname(dto.getLastname());
		user.setEmail(dto.getEmail());
		user.setPhoneNo(dto.getPhoneNo());
		user.setStatus(dto.getStatus());
		user.setRole(dto.getRole());
		user.setDob(dto.getDob());
		user.setGender(dto.getGender());
		return user;
	}

	private ProductDTO mapToDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setDescription(product.getDescription());
		dto.setPrice(product.getPrice());
		dto.setDiscountPrice(product.getDiscountPrice());
		dto.setStockQuanty(product.getStockQuanty());
		dto.setBrand(product.getBrand());
		dto.setCategory(product.getCategory());
		dto.setTag(product.getTag());
		dto.setAddedDate(product.getAddedDate());
		dto.setManufactuer(product.getManufactuer());
		dto.setAverageRating(product.getAverageRating());
		dto.setTotalReview(product.getTotalReview());
		dto.setAvailabilitystatus(product.getAvailabilitystatus());
		return dto;
	}

	private Product mapToEntity(ProductDTO dto) {
		Product product = new Product();
		product.setId(dto.getId());
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());
		product.setDiscountPrice(dto.getDiscountPrice());
		product.setStockQuanty(dto.getStockQuanty());
		product.setBrand(dto.getBrand());
		product.setCategory(dto.getCategory());
		product.setTag(dto.getTag());
		product.setAddedDate(dto.getAddedDate());
		product.setManufactuer(dto.getManufactuer());
		product.setAverageRating(dto.getAverageRating());
		product.setTotalReview(dto.getTotalReview());
		product.setAvailabilitystatus(dto.getAvailabilitystatus());
		return product;
	}
}
