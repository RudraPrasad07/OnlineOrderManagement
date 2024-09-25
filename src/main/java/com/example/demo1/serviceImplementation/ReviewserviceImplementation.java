package com.example.demo1.serviceImplementation;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.DTO.ReviewDTO;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.Reviewdao;
import com.example.demo1.service.ReviewService;

@Service
public class ReviewserviceImplementation implements ReviewService {
	@Autowired
	private Reviewdao dao;

	@Override
	public ResponseStructure<ReviewDTO> saveReview(ReviewDTO r) {
		ReviewDTO saveReview = dao.saveReview(r);
		return new ResponseStructure<>(201, "Data Saved Sucessfully", saveReview, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<ReviewDTO> updateReview(int id, ReviewDTO r) {
		ReviewDTO updateReview = dao.updateReview(id, r);
		return new ResponseStructure<>(200, "Data Updated Sucessfully", updateReview, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<ReviewDTO> fetchById(int id) {
		ReviewDTO review = dao.fetchById(id);
		return new ResponseStructure<>(200, "Data Fetched Sucessfully With The Id", review, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<ReviewDTO>> fetchByRating(int rating) {
		List<ReviewDTO> list = dao.fetchByRating(rating);
		return new ResponseStructure<>(200, "Data Fetched Sucessfully By The Rating", list, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<ReviewDTO>> fetchByReviewDate(Date reviewDate) {
		List<ReviewDTO> list = dao.fetchByReviewDate(reviewDate);
		return new ResponseStructure<>(200, "Data Fetched Sucessfully By The ReviewDate", list, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<ReviewDTO>> fetchByPhoneNo(long phoneNo) {
		List<ReviewDTO> list = dao.fetchByPhoneNo(phoneNo);
		return new ResponseStructure<>(200, "Data Fetched Sucessfully By The PhoneNumber", list, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<ReviewDTO> deleteById(int id) {
		dao.deleteById(id);
		return new ResponseStructure<>(200, "Data Fetched Sucessfully By The ReviewDate", null, LocalDateTime.now());
	}
}
