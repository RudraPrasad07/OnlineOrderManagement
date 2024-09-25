package com.example.demo1.service;

import java.sql.Date;
import java.util.List;

import com.example.demo1.DTO.ReviewDTO;
import com.example.demo1.Utility.ResponseStructure;

public interface ReviewService {

	ResponseStructure<ReviewDTO> saveReview(ReviewDTO r);

	ResponseStructure<ReviewDTO> updateReview(int id, ReviewDTO r);

	ResponseStructure<ReviewDTO> fetchById(int id);

	ResponseStructure<List<ReviewDTO>> fetchByRating(int rating);

	ResponseStructure<List<ReviewDTO>> fetchByReviewDate(Date reviewDate);

	ResponseStructure<List<ReviewDTO>> fetchByPhoneNo(long phoneNo);

	ResponseStructure<ReviewDTO> deleteById(int id);

}
