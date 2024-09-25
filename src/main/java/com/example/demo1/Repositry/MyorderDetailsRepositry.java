package com.example.demo1.Repositry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.Entity.MyorderDetails;

public interface MyorderDetailsRepositry extends JpaRepository<MyorderDetails, Integer> {
	List<MyorderDetails> findByShippingMethod(String shippingMethod);

	boolean existsByShippingMethod(String shippingMethod);

	List<MyorderDetails> findByPaymentMethod(String paymentMethod);

	boolean existsByPaymentMethod(String paymentMethod);

	Optional<MyorderDetails> findByTrackingnumber(String trackingnumber);

	List<MyorderDetails> findByExpectedDeliveryDate(LocalDateTime expectedDeliveryDate);

}
