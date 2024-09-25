package com.example.demo1.service;

import java.util.List;

import com.example.demo1.DTO.ProductDTO;
import com.example.demo1.Utility.ResponseStructure;

public interface ProductService {
	ResponseStructure<ProductDTO> saveProduct(ProductDTO p);

	ResponseStructure<ProductDTO> updateProduct(int id, ProductDTO p);

	ResponseStructure<ProductDTO> fetchByid(int id);

	ResponseStructure<List<ProductDTO>> fetchByName(String name);

	ResponseStructure<List<ProductDTO>> fetchByPrice(double Price);

	ResponseStructure<List<ProductDTO>> fetchBystockQuanty(int stockQuanty);

	ResponseStructure<ProductDTO> deleteByid(int id);

	ResponseStructure<List<ProductDTO>> fetchBycategory(String category);

	ResponseStructure<List<ProductDTO>> fetchAllProduct();

}
