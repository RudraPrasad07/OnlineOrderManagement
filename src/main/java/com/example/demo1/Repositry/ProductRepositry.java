package com.example.demo1.Repositry;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.Entity.Product;

public interface ProductRepositry extends JpaRepository<Product, Integer> {

	public List<Product> findByName(String name);

	public boolean existsByName(String name);

	public List<Product> findByPrice(double price);

	public boolean existsByPrice(double price);

	public List<Product> findByStockQuanty(int stockQuanty);

	public boolean existsByStockQuanty(int stockQuanty);

	public List<Product> findByCategory(String category);

	public boolean existsByCategory(String category);

}
