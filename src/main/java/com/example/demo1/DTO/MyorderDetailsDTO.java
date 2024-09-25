package com.example.demo1.DTO;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyorderDetailsDTO {
	private int id;
	private double totalAmount;
	private String shippingMethod;
	private String paymentMethod;
	private String status;
	private String trackingnumber;
	private LocalDateTime expectedDeliveryDate;
	private String additionalNotes;

}
