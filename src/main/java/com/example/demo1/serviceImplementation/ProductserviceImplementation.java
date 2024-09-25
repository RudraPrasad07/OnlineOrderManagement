package com.example.demo1.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.DTO.ProductDTO;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.ProductDao;
import com.example.demo1.service.ProductService;

@Service
public class ProductserviceImplementation implements ProductService {
	@Autowired
	private ProductDao dao;

	@Override
	public ResponseStructure<ProductDTO> saveProduct(ProductDTO p) {
		ProductDTO saveProduct = dao.saveProduct(p);
		return new ResponseStructure<>(201, "Product Saved Sucessfully", saveProduct, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<ProductDTO> updateProduct(int id, ProductDTO p) {
		ProductDTO product = dao.updateProduct(id, p);
		return new ResponseStructure<>(200, "Product Updated Sucessfully", product, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<ProductDTO> fetchByid(int id) {
		ProductDTO product = dao.fetchByid(id);
		return new ResponseStructure<>(200, "Product fetched Sucessfully with The Id", product, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<ProductDTO>> fetchByName(String name) {
		List<ProductDTO> list = dao.fetchByName(name);
		return new ResponseStructure<>(200, "Product Fetched Sucessfully With The Name", list, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<ProductDTO>> fetchByPrice(double Price) {
		List<ProductDTO> list = dao.fetchByPrice(Price);
		return new ResponseStructure<>(200, "Product Fetched Sucessfully With The Price", list, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<ProductDTO>> fetchBystockQuanty(int stockQuanty) {
		List<ProductDTO> list = dao.fetchBystockQuanty(stockQuanty);
		return new ResponseStructure<>(200, "Product Fetched Sucessfully With The StockQuanty", list,
				LocalDateTime.now());

	}

	@Override
	public ResponseStructure<ProductDTO> deleteByid(int id) {
		dao.deleteByid(id);
		return new ResponseStructure<>(204, "data Deleted Sucessfully", null, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<ProductDTO>> fetchBycategory(String category) {
		List<ProductDTO> list = dao.fetchBycategory(category);
		return new ResponseStructure<>(200, "Product Fetched Sucessfully from The Database", list, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<ProductDTO>> fetchAllProduct() {
		List<ProductDTO> list = dao.fetchAllProduct();
		return new ResponseStructure<>(200, "All Product Are Fetched Sucessfully", list, LocalDateTime.now());
	}
}
