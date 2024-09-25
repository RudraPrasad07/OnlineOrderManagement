package com.example.demo1.dao;

import java.util.List;

import com.example.demo1.DTO.ProductDTO;

public interface ProductDao {
	ProductDTO saveProduct(ProductDTO p);

	ProductDTO updateProduct(int id, ProductDTO p);

	ProductDTO fetchByid(int id);

	List<ProductDTO> fetchByName(String name);

	List<ProductDTO> fetchByPrice(double Price);

	List<ProductDTO> fetchBystockQuanty(int stockQuanty);

	List<ProductDTO> fetchBycategory(String category);

	boolean deleteByid(int id);

	List<ProductDTO> fetchAllProduct();

}
