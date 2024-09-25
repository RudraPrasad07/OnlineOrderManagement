package com.example.demo1.Entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	private String lastname;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private long phoneNo;
	private String status;
	private String role;
	@Column(nullable = false)
	private Date dob;
	@Column(nullable = false)
	private char gender;
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime reagistrationdate;
	@UpdateTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime lastlogin;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address addresses;
	@OneToMany(mappedBy = "users")
	private List<Review> reviews;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MyorderDetails> orders;

	@OneToOne(mappedBy = "user")
	private Cart cart;

	
}
