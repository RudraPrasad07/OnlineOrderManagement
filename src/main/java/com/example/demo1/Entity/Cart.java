package com.example.demo1.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int productCount;
	private double totalprice;
	private int stockQuentity;
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Product> products;
}
