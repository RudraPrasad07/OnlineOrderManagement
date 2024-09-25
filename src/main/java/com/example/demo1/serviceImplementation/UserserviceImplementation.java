package com.example.demo1.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.DTO.UserDTO;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.UserDao;
import com.example.demo1.service.UserService;

@Service
public class UserserviceImplementation implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public ResponseStructure<UserDTO> saveUser(UserDTO u) {
		UserDTO saveUser = dao.saveUser(u);
		return new ResponseStructure<>(201, "Data Saved Sucessfully In The Database", saveUser, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<UserDTO> updateUser(int id, UserDTO u) {
		UserDTO user = dao.updateUser(id, u);
		return new ResponseStructure<>(200, "Data Updated Sucessfully", user, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<UserDTO> fetchByID(int id) {
		UserDTO user = dao.fetchByID(id);
		return new ResponseStructure<>(200, "Data Fetched Sucessfully", user, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<UserDTO> fetchByEmail(String email) {
		UserDTO user = dao.fetchByEmail(email);
		return new ResponseStructure<>(200, "Data Fetched Sucessfully", user, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<UserDTO> fetchByNumber(long phoneNo) {
		UserDTO user = dao.fetchByNumber(phoneNo);
		return new ResponseStructure<>(200, "Data Fetched Sucessfully", user, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<UserDTO> deleteByID(int id) {
		dao.deleteByID(id);
		return new ResponseStructure<>(200, "Data Deleted Sucessfully", null, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<UserDTO> deleteByPhoneNo(long phoneNo) {
		dao.deleteByPhoneNo(phoneNo);
		return new ResponseStructure<>(200, "Data Deleted Sucessfully", null, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<UserDTO>> fetchByName(String name) {
		List<UserDTO> list = dao.fetchByName(name);
		return new ResponseStructure<>(200, "Data Fetched Sucessfully", list, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<UserDTO>> fetchallUser() {
		List<UserDTO> list = dao.fetchallUser();
		return new ResponseStructure<>(200, "All Data Are Fetched Sucessfully", list, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Boolean> existByEmail(String email) {

		Boolean existByEmail = dao.existByEmail(email);
		return new ResponseStructure<Boolean>(200, "Data Is Prsent With The email", existByEmail, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Boolean> existsByNumber(long phoneNo) {
		Boolean number = dao.existsByNumber(phoneNo);
		return new ResponseStructure<Boolean>(200, "Data Is Prsent With The Phonenumber", number, LocalDateTime.now());
	}

}
