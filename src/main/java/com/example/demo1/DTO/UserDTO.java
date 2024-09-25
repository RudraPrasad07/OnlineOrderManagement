package com.example.demo1.DTO;

import java.sql.Date;
import com.example.demo1.Entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private int id;
	private String name;
	private String lastname;
	private String email;
	private long phoneNo;
	private String status;
	private String role;
	private Date dob;
	private char gender;
	private Address addresses;

}
