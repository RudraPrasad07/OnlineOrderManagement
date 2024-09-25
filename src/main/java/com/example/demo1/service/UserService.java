package com.example.demo1.service;

import java.util.List;

import com.example.demo1.DTO.UserDTO;
import com.example.demo1.Utility.ResponseStructure;

public interface UserService {
	ResponseStructure<UserDTO> saveUser(UserDTO u);

	ResponseStructure<UserDTO> updateUser(int id, UserDTO u);

	ResponseStructure<UserDTO> fetchByID(int id);

	ResponseStructure<UserDTO> fetchByEmail(String email);

	ResponseStructure<UserDTO> fetchByNumber(long phoneNo);

	ResponseStructure<List<UserDTO>> fetchByName(String name);

	ResponseStructure<List<UserDTO>> fetchallUser();

	ResponseStructure<UserDTO> deleteByID(int id);

	ResponseStructure<UserDTO> deleteByPhoneNo(long phoneNo);

	ResponseStructure<Boolean> existByEmail(String email);

	ResponseStructure<Boolean> existsByNumber(long phoneNo);

}
