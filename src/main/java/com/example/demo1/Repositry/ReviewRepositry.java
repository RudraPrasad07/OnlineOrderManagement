package com.example.demo1.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.Entity.Review;
import java.util.List;
import java.sql.Date;
import com.example.demo1.Entity.User;

public interface ReviewRepositry extends JpaRepository<Review, Integer> {

	List<Review> findByRating(int rating);

	boolean existsByRating(int rating);

	List<Review> findByReviewDate(Date reviewDate);

	boolean existsByReviewDate(Date reviewDate);

	List<Review> findByUsers(User users);

	boolean existsByUsers(User users);

}
