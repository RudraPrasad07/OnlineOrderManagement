package com.example.demo1.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo1.Utility.ResponseStructure;

@RestControllerAdvice
public class HandlingException {
	@ExceptionHandler(EntityNotPresentException.class)
	public ResponseEntity<ResponseStructure<String>> EntityNotPresentException(EntityNotPresentException e) {
		ResponseStructure<String> structure = new ResponseStructure<String>(HttpStatus.CONFLICT.value(), e.getMessage(),
				null, LocalDateTime.now());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(AlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> AlreadyExists(AlreadyExists e) {

		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				null, LocalDateTime.now());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RattingoutOfBoundException.class)
	public ResponseEntity<ResponseStructure<String>> RattingoutOfBoundException(RattingoutOfBoundException r) {
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.NOT_ACCEPTABLE.value(), r.getMessage(),
				null, LocalDateTime.now());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(EntityObjectIsNotPresent.class)
	public ResponseEntity<ResponseStructure<Object>> EntityNotPresentExceptionForObject(EntityObjectIsNotPresent e) {
		ResponseStructure<Object> structure = new ResponseStructure<>(HttpStatus.CONFLICT.value(), e.getMessage(), null,
				LocalDateTime.now());

		return new ResponseEntity<ResponseStructure<Object>>(structure, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(StockQuentityExceedException.class)
	public ResponseEntity<ResponseStructure<String>> StockQuentityExceedException(StockQuentityExceedException s) {
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.INSUFFICIENT_STORAGE.value(),
				s.getMessage(), null, LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.INSUFFICIENT_STORAGE);
	}

	@ExceptionHandler(DeliveryDateNotPresentException.class)
	public ResponseEntity<ResponseStructure<String>> DeliveryDateNotPresentException(
			DeliveryDateNotPresentException e) {
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage(),
				null, LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_ACCEPTABLE);
	}
}
