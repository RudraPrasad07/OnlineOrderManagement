package com.example.demo1.daoImplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.DTO.ProductDTO;
import com.example.demo1.Entity.Product;
import com.example.demo1.Exception.EntityNotPresentException;
import com.example.demo1.Repositry.ProductRepositry;
import com.example.demo1.dao.ProductDao;

@Repository
public class ProductDaoImplementation implements ProductDao {
	@Autowired
	private ProductRepositry repositry;

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
		product.setAddedDate(dto.getAddedDate());
		product.setTag(dto.getTag());
		product.setManufactuer(dto.getManufactuer());
		product.setAverageRating(dto.getAverageRating());
		product.setTotalReview(dto.getTotalReview());
		product.setAvailabilitystatus(dto.getAvailabilitystatus());
		return product;
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
		dto.setAddedDate(product.getAddedDate());
		dto.setTag(product.getTag());
		dto.setManufactuer(product.getManufactuer());
		dto.setAverageRating(product.getAverageRating());
		dto.setTotalReview(product.getTotalReview());
		dto.setAvailabilitystatus(product.getAvailabilitystatus());
		return dto;
	}

	@Override
	public ProductDTO saveProduct(ProductDTO p) {
		Product product = mapToEntity(p);
		Product savedProduct = repositry.save(product);
		return mapToDTO(savedProduct);
	}

	@Override
	public ProductDTO updateProduct(int id, ProductDTO p) {
		fetchByid(id);
		p.setId(id);
		Product updatedProduct = repositry.save(mapToEntity(p));
		return mapToDTO(updatedProduct);
	}

	@Override
	public ProductDTO fetchByid(int id) {
		Optional<Product> optional = repositry.findById(id);
		Product product = optional.orElseThrow(
				() -> new EntityNotPresentException("Entity Not Present With The ID " + id + " that is given"));
		return mapToDTO(product);
	}

	@Override
	public List<ProductDTO> fetchByName(String name) {
		List<Product> optional = repositry.findByName(name);
		if (optional.isEmpty()) {
			throw new EntityNotPresentException("Entity Not Present With The name " + name + " that is given");
		}
		return optional.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public List<ProductDTO> fetchByPrice(double price) {
		List<Product> products = repositry.findByPrice(price);
		if (products.isEmpty()) {
			throw new EntityNotPresentException("Entity Not Present With The Price " + price + " that Is given");
		}
		return products.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public List<ProductDTO> fetchBystockQuanty(int stockQuanty) {
		List<Product> optional = repositry.findByStockQuanty(stockQuanty);
		if (optional.isEmpty()) {
			throw new EntityNotPresentException(
					"Entity Not Present With The stockQuanty " + stockQuanty + " that Is given");
		}
		return optional.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public boolean deleteByid(int id) {
		repositry.delete(mapToEntity(fetchByid(id)));
		return true;
	}

	@Override
	public List<ProductDTO> fetchBycategory(String category) {
		List<Product> optional = repositry.findByCategory(category);
		if (optional.isEmpty()) {
			new EntityNotPresentException("Entity Not Present With the Category " + category + " that is given");
		}
		return optional.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public List<ProductDTO> fetchAllProduct() {
		List<Product> list = repositry.findAll();
		return list.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
}
