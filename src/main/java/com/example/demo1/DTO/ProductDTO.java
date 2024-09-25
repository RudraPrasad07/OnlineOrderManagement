package com.example.demo1.DTO;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private int id;
	private String name;
	private String description;
	private double price;

	private double discountPrice;
	private int stockQuanty;
	private String brand;
	private String category;
	private LocalDateTime addedDate;

	private String tag;
	private String manufactuer;
	private double averageRating;
	private int totalReview;
	private String availabilitystatus;

}
