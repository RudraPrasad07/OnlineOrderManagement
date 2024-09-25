package com.example.demo1.DTO;

import java.util.List;

import com.example.demo1.Entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
	private int id;

	private int productCount;
	private double totalprice;
	private int stockQuentity;
	private List<Product> products;
}
