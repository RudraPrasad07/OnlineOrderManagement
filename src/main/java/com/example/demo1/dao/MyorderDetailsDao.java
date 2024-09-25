package com.example.demo1.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo1.DTO.MyorderDetailsDTO;

public interface MyorderDetailsDao {
	MyorderDetailsDTO createOrder(MyorderDetailsDTO details, int userID);

	List<MyorderDetailsDTO> getAllOrder();

	MyorderDetailsDTO getOrderById(int id);

	MyorderDetailsDTO UpdateOrderId(int id, MyorderDetailsDTO details);

	boolean deleteOrderById(int id);

	List<MyorderDetailsDTO> getOrderByshippingMethod(String shippingMethod);

	List<MyorderDetailsDTO> getOrderBypaymentMethod(String paymentMethod);

	MyorderDetailsDTO getOrderByTrackingNumber(String TrackingNumber);

	List<MyorderDetailsDTO> getOrderByDeliveryDate(LocalDateTime expectedDeliveryDate);

}
