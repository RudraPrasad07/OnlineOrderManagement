package com.example.demo1.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.DTO.MyorderDetailsDTO;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.MyorderDetailsDao;
import com.example.demo1.service.MyorderDetailsService;

@Service
public class MyorderDetailsserviceImplementation implements MyorderDetailsService {
	@Autowired
	private MyorderDetailsDao dao;

	@Override
	public ResponseStructure<MyorderDetailsDTO> createOrder(MyorderDetailsDTO details, int userID) {
		MyorderDetailsDTO order = dao.createOrder(details, userID);
		return new ResponseStructure<MyorderDetailsDTO>(201, "Data Created Sucessfully Inside The Database", order,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<MyorderDetailsDTO>> getAllOrder() {
		List<MyorderDetailsDTO> allOrder = dao.getAllOrder();
		return new ResponseStructure<List<MyorderDetailsDTO>>(200, "Data Fetched Sucessfully", allOrder,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<MyorderDetailsDTO> getOrderById(int id) {
		MyorderDetailsDTO details = dao.getOrderById(id);
		return new ResponseStructure<MyorderDetailsDTO>(200, "Data Fetched Sucessfully By the ID", details,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<MyorderDetailsDTO> UpdateOrderId(int id, MyorderDetailsDTO details) {
		MyorderDetailsDTO orderId = dao.UpdateOrderId(id, details);
		return new ResponseStructure<MyorderDetailsDTO>(200, "Data Updated Sucessfully Inside The DataBase", orderId,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<MyorderDetailsDTO> deleteOrderById(int id) {
		dao.deleteOrderById(id);
		return new ResponseStructure<MyorderDetailsDTO>(200, "Data Deleted SucessFully", null, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<MyorderDetailsDTO>> getOrderByshippingMethod(String shippingMethod) {
		List<MyorderDetailsDTO> list = dao.getOrderBypaymentMethod(shippingMethod);
		return new ResponseStructure<List<MyorderDetailsDTO>>(200, "Daata Fetched Sucessfully", list,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<MyorderDetailsDTO>> getOrderBypaymentMethod(String paymentMethod) {
		List<MyorderDetailsDTO> list = dao.getOrderBypaymentMethod(paymentMethod);
		return new ResponseStructure<List<MyorderDetailsDTO>>(200, "Data Fetched Sucessfully for paymentMethod", list,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<MyorderDetailsDTO> getOrderByTrackingNumber(String TrackingNumber) {
		MyorderDetailsDTO details = dao.getOrderByTrackingNumber(TrackingNumber);
		return new ResponseStructure<MyorderDetailsDTO>(200, "Data Fetched sucessfully", details, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<MyorderDetailsDTO>> getOrderByDeliveryDate(LocalDateTime expectedDeliveryDate) {
		List<MyorderDetailsDTO> list = dao.getOrderByDeliveryDate(expectedDeliveryDate);
		return new ResponseStructure<List<MyorderDetailsDTO>>(200, "Data Fetched Sucessfully From The DataBase", list,
				LocalDateTime.now());
	}
}
