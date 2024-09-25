package com.example.demo1.DTO;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
	private int id;
	private String review;
	private int rating;
	private LocalDateTime reviewDate;
	private UserDTO users;

}
