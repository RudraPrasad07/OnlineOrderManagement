package com.example.demo1.Entity;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyorderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(updatable = false, nullable = true)
	private double totalAmount;

	@Column(nullable = false)
	private String shippingMethod;

	@Column(nullable = false)
	private String paymentMethod;

	@Column(nullable = false)
	private String status;

	@Column(nullable = false, unique = true, updatable = false)
	private String trackingnumber;

	@Column(nullable = false, updatable = false)
	private LocalDateTime expectedDeliveryDate;

	private String additionalNotes;

	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	@ManyToMany(mappedBy = "myorder")
	private List<Product> products;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

}
