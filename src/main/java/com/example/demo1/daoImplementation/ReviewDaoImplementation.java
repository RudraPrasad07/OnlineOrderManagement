package com.example.demo1.daoImplementation;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.DTO.ReviewDTO;
import com.example.demo1.DTO.UserDTO;
import com.example.demo1.Entity.Review;
import com.example.demo1.Entity.User;
import com.example.demo1.Exception.EntityNotPresentException;
import com.example.demo1.Exception.EntityObjectIsNotPresent;
import com.example.demo1.Exception.RattingoutOfBoundException;
import com.example.demo1.Repositry.ReviewRepositry;
import com.example.demo1.Repositry.UserRepositry;
import com.example.demo1.dao.Reviewdao;

@Repository
public class ReviewDaoImplementation implements Reviewdao {

	@Autowired
	private ReviewRepositry repositry;

	@Autowired
	private UserRepositry userRepositry;

	@Override
	public ReviewDTO saveReview(ReviewDTO r) {
		Optional<User> optionalUser = userRepositry.findById(r.getUsers().getId());
		if (!optionalUser.isPresent()) {
			throw new EntityNotPresentException("User Not Present In The Database. Please Create a User.");
		}

		if (r.getRating() < 0 || r.getRating() > 5) {
			throw new RattingoutOfBoundException("The Given Rating " + r.getRating() + " is Not Acceptable.");
		}

		Review reviewEntity = mapToEntity(r);
		Review savedReview = repositry.save(reviewEntity);
		return mapToDTO(savedReview);
	}

	@Override
	public ReviewDTO updateReview(int id, ReviewDTO r) {

		fetchById(id);

		if (r.getRating() < 0 || r.getRating() > 5) {
			throw new RattingoutOfBoundException("The Given Rating " + r.getRating() + " is Not Acceptable.");
		}

		r.setId(id);
		Review reviewEntity = mapToEntity(r);
		Review updatedReview = repositry.save(reviewEntity);
		return mapToDTO(updatedReview);
	}

	@Override
	public ReviewDTO fetchById(int id) {
		Review orElseThrow = repositry.findById(id).orElseThrow(
				() -> new EntityNotPresentException("The Given Id " + id + " is Not Present In the Database."));
		return mapToDTO(orElseThrow);
	}

	@Override
	public List<ReviewDTO> fetchByRating(int rating) {
		List<Review> reviews = repositry.findByRating(rating);
		if (reviews.isEmpty()) {
			throw new EntityNotPresentException("The Given Rating " + rating + " is Not Present In the Database.");
		}
		return reviews.stream().map(this::mapToDTO).toList();
	}

	@Override
	public List<ReviewDTO> fetchByReviewDate(Date reviewDate) {
		List<Review> reviews = repositry.findByReviewDate(reviewDate);
		if (reviews.isEmpty()) {
			throw new EntityNotPresentException("The Given Date " + reviewDate + " is Not Present In the Database.");
		}
		return reviews.stream().map(this::mapToDTO).toList();
	}

	@Override
	public List<ReviewDTO> fetchByPhoneNo(long phoneNo) {
		Optional<User> optionalUser = userRepositry.findByPhoneNo(phoneNo);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			List<Review> reviews = repositry.findByUsers(user);
			return reviews.stream().map(this::mapToDTO).toList();
		} else {
			throw new EntityObjectIsNotPresent("The Given Number " + phoneNo + " Is Not Present.");
		}
	}

	@Override
	public boolean deleteById(int id) {
		Review review = repositry.findById(id).orElseThrow(
				() -> new EntityNotPresentException("The Given OrderId " + id + " Is not present In the DataBase"));
		repositry.delete(review);
		return true;
	}

	private Review mapToEntity(ReviewDTO dto) {
		Review review = new Review();
		review.setId(dto.getId());
		review.setRating(dto.getRating());
		review.setReview(dto.getReview());
		review.setReviewDate(dto.getReviewDate());

		User userEntity = mapToEntity(dto.getUsers());
		review.setUsers(userEntity);

		return review;
	}

	private ReviewDTO mapToDTO(Review review) {
		ReviewDTO dto = new ReviewDTO();
		dto.setId(review.getId());
		dto.setRating(review.getRating());
		dto.setReview(review.getReview());
		dto.setReviewDate(review.getReviewDate());
		UserDTO userDTO = mapUserEntityToDTO(review.getUsers());
		dto.setUsers(userDTO);

		return dto;
	}

	private User mapToEntity(UserDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setLastname(dto.getLastname());
		user.setEmail(dto.getEmail());
		user.setPhoneNo(dto.getPhoneNo());
		user.setStatus(dto.getStatus());
		user.setRole(dto.getRole());
		user.setDob(dto.getDob());
		user.setGender(dto.getGender());
		return user;
	}

	private UserDTO mapUserEntityToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setLastname(user.getLastname());
		userDTO.setEmail(user.getEmail());
		userDTO.setPhoneNo(user.getPhoneNo());
		userDTO.setStatus(user.getStatus());
		userDTO.setRole(user.getRole());
		userDTO.setDob(user.getDob());
		userDTO.setGender(user.getGender());
		return userDTO;
	}

}
