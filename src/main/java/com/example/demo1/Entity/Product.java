package com.example.demo1.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private double price;

	private double discountPrice;

	@Column(nullable = false)
	private int stockQuanty;

	@Column(nullable = false, unique = true)
	private String brand;

	@Column(nullable = false)
	private String category;

	private String tag;
	@CurrentTimestamp
	private LocalDateTime addedDate;

	@Column(nullable = false)
	private String manufactuer;

	@Column(nullable = false)
	private double averageRating;

	@Column(nullable = false)
	private int totalReview;

	@Column(nullable = false)
	private String availabilitystatus;

	@ManyToMany(mappedBy = "products")
	private List<WishList> wishLists;
	@ManyToMany
	private List<MyorderDetails> myorder;

}
