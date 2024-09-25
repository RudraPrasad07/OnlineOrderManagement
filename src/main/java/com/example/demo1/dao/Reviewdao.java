package com.example.demo1.dao;

import java.sql.Date;
import java.util.List;
import com.example.demo1.DTO.ReviewDTO;

public interface Reviewdao {

	ReviewDTO saveReview(ReviewDTO r);

	ReviewDTO updateReview(int id, ReviewDTO r);

	ReviewDTO fetchById(int id);

	List<ReviewDTO> fetchByRating(int rating);

	List<ReviewDTO> fetchByReviewDate(Date reviewDate);

	List<ReviewDTO> fetchByPhoneNo(long phoneNo);

	boolean deleteById(int id);

}
