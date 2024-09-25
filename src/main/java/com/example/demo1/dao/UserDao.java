package com.example.demo1.dao;

import java.util.List;

import com.example.demo1.DTO.UserDTO;

public interface UserDao {
	UserDTO saveUser(UserDTO u);

	UserDTO updateUser(int id, UserDTO u);

	UserDTO fetchByID(int id);

	UserDTO fetchByEmail(String email);

	UserDTO fetchByNumber(long phoneNo);

	boolean deleteByID(int id);

	boolean deleteByPhoneNo(long phoneNo);

	List<UserDTO> fetchByName(String name);

	List<UserDTO> fetchallUser();

	Boolean existByEmail(String email);

	Boolean existsByNumber(long phoneNo);

}
