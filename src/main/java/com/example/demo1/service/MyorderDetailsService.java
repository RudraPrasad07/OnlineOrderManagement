package com.example.demo1.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo1.DTO.MyorderDetailsDTO;
import com.example.demo1.Utility.ResponseStructure;

public interface MyorderDetailsService {

	ResponseStructure<MyorderDetailsDTO> createOrder(MyorderDetailsDTO details, int userID);

	ResponseStructure<List<MyorderDetailsDTO>> getAllOrder();

	ResponseStructure<MyorderDetailsDTO> getOrderById(int id);

	ResponseStructure<MyorderDetailsDTO> UpdateOrderId(int id, MyorderDetailsDTO details);

	ResponseStructure<MyorderDetailsDTO> deleteOrderById(int id);

	ResponseStructure<List<MyorderDetailsDTO>> getOrderByshippingMethod(String shippingMethod);

	ResponseStructure<List<MyorderDetailsDTO>> getOrderBypaymentMethod(String paymentMethod);

	ResponseStructure<MyorderDetailsDTO> getOrderByTrackingNumber(String TrackingNumber);

	ResponseStructure<List<MyorderDetailsDTO>> getOrderByDeliveryDate(LocalDateTime expectedDeliveryDate);
}
