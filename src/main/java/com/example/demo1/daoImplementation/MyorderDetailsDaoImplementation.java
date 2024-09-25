package com.example.demo1.daoImplementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.DTO.MyorderDetailsDTO;
import com.example.demo1.Entity.MyorderDetails;
import com.example.demo1.Entity.User;
import com.example.demo1.Exception.DeliveryDateNotPresentException;
import com.example.demo1.Exception.EntityNotPresentException;
import com.example.demo1.Repositry.MyorderDetailsRepositry;
import com.example.demo1.Repositry.UserRepositry;
import com.example.demo1.dao.MyorderDetailsDao;

@Repository
public class MyorderDetailsDaoImplementation implements MyorderDetailsDao {

	@Autowired
	private MyorderDetailsRepositry repositry;

	@Autowired
	private UserRepositry dao;

	@Override
	public MyorderDetailsDTO createOrder(MyorderDetailsDTO details, int userID) {

		User byId = dao.findById(userID)
				.orElseThrow(() -> new EntityNotPresentException("User with ID " + userID + " does not exist."));

		details.setTotalAmount(byId.getCart().getTotalprice());

		if (details.getTrackingnumber() == null || details.getTrackingnumber().isEmpty()) {
			String trackingNumber = generateTrackingNumber();
			details.setTrackingnumber(trackingNumber);
		}

		if ("express".equalsIgnoreCase(details.getShippingMethod())) {
			details.setExpectedDeliveryDate(LocalDateTime.now().plusDays(2));
		} else {
			details.setExpectedDeliveryDate(LocalDateTime.now().plusDays(5));
		}

		MyorderDetails order = toEntity(details);

		order.setUser(byId);

		MyorderDetails savedOrder = repositry.save(order);

		return toDTO(savedOrder);
	}

	@Override
	public List<MyorderDetailsDTO> getAllOrder() {
		List<MyorderDetails> orders = repositry.findAll();
		return orders.stream().map(this::toDTO).toList();
	}

	@Override
	public MyorderDetailsDTO getOrderById(int id) {
		Optional<MyorderDetails> byId = repositry.findById(id);
		MyorderDetails orderDetails = byId.orElseThrow(
				() -> new EntityNotPresentException("The Given OrderId " + id + " Is not present In the DataBase"));
		return toDTO(orderDetails);
	}

	@Override
	public MyorderDetailsDTO UpdateOrderId(int id, MyorderDetailsDTO details) {
		MyorderDetails existingOrder = repositry.findById(id).orElseThrow(
				() -> new EntityNotPresentException("The Given OrderId " + id + " Is not present In the DataBase"));

		existingOrder.setTotalAmount(details.getTotalAmount());
		existingOrder.setShippingMethod(details.getShippingMethod());
		existingOrder.setPaymentMethod(details.getPaymentMethod());
		existingOrder.setExpectedDeliveryDate(details.getExpectedDeliveryDate());
		existingOrder.setTrackingnumber(details.getTrackingnumber());

		MyorderDetails updatedOrder = repositry.save(existingOrder);
		return toDTO(updatedOrder);
	}

	@Override
	public boolean deleteOrderById(int id) {
		MyorderDetails orderDetails = repositry.findById(id).orElseThrow(
				() -> new EntityNotPresentException("The Given OrderId " + id + " Is not present In the DataBase"));
		repositry.delete(orderDetails);
		return true;
	}

	@Override
	public List<MyorderDetailsDTO> getOrderByshippingMethod(String shippingMethod) {
		List<MyorderDetails> byShippingMethod = repositry.findByShippingMethod(shippingMethod);
		if (byShippingMethod.isEmpty()) {
			throw new EntityNotPresentException(
					"The Given Shipping Method " + shippingMethod + " Is Not Present in The DataBase");
		}
		return byShippingMethod.stream().map(this::toDTO).toList();
	}

	@Override
	public List<MyorderDetailsDTO> getOrderBypaymentMethod(String paymentMethod) {
		List<MyorderDetails> byPaymentMethod = repositry.findByPaymentMethod(paymentMethod);
		if (byPaymentMethod.isEmpty()) {
			throw new EntityNotPresentException(
					"The Given Payment Method " + paymentMethod + " Is Not Present in The DataBase");
		}
		return byPaymentMethod.stream().map(this::toDTO).toList();
	}

	@Override
	public MyorderDetailsDTO getOrderByTrackingNumber(String trackingNumber) {
		Optional<MyorderDetails> optional = repositry.findByTrackingnumber(trackingNumber);
		MyorderDetails orderDetails = optional.orElseThrow(() -> new EntityNotPresentException(
				"Entity Not Present With The Tracking Number " + trackingNumber + " In The Database"));
		return toDTO(orderDetails);
	}

	@Override
	public List<MyorderDetailsDTO> getOrderByDeliveryDate(LocalDateTime expectedDeliveryDate) {
		List<MyorderDetails> optional = repositry.findByExpectedDeliveryDate(expectedDeliveryDate);
		if (optional.isEmpty()) {
			throw new DeliveryDateNotPresentException(
					"The given Delivery Date " + expectedDeliveryDate + " is Not Present In The DataBase");
		}
		return optional.stream().map(this::toDTO).toList();
	}

	public String generateTrackingNumber() {
		LocalDateTime time = LocalDateTime.now();
		String timeStamp = String.format("%04d%02d%02d%02d%02d%02d%06d", time.getYear(), time.getMonthValue(),
				time.getDayOfMonth(), time.getHour(), time.getMinute(), time.getSecond(), time.getNano());
		String randomAlpha = generateAlphanumeric(7);
		return "TRK-" + randomAlpha + "-" + timeStamp;
	}

	private String generateAlphanumeric(int length) {
		SecureRandom random = new SecureRandom();
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(chars.charAt(random.nextInt(chars.length())));
		}
		return sb.toString();
	}

	private MyorderDetails toEntity(MyorderDetailsDTO dto) {
		MyorderDetails details = new MyorderDetails();
		details.setId(dto.getId());
		details.setTotalAmount(dto.getTotalAmount());
		details.setTrackingnumber(dto.getTrackingnumber());
		details.setShippingMethod(dto.getShippingMethod());
		details.setExpectedDeliveryDate(dto.getExpectedDeliveryDate());
		details.setPaymentMethod(dto.getPaymentMethod());
		details.setStatus(dto.getStatus());
		details.setAdditionalNotes(dto.getAdditionalNotes());
		return details;
	}

	private MyorderDetailsDTO toDTO(MyorderDetails entity) {
		MyorderDetailsDTO dto = new MyorderDetailsDTO();
		dto.setId(entity.getId());
		dto.setTotalAmount(entity.getTotalAmount());
		dto.setTrackingnumber(entity.getTrackingnumber());
		dto.setShippingMethod(entity.getShippingMethod());
		dto.setExpectedDeliveryDate(entity.getExpectedDeliveryDate());
		dto.setPaymentMethod(entity.getPaymentMethod());
		dto.setStatus(entity.getStatus());
		dto.setAdditionalNotes(entity.getAdditionalNotes());
		return dto;
	}

}
