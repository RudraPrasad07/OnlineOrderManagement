package com.example.demo1.daoImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.DTO.UserDTO;
import com.example.demo1.Entity.Cart;
import com.example.demo1.Entity.User;
import com.example.demo1.Entity.WishList;
import com.example.demo1.Exception.AlreadyExists;
import com.example.demo1.Exception.EntityNotPresentException;
import com.example.demo1.Repositry.CartRepositry;
import com.example.demo1.Repositry.UserRepositry;
import com.example.demo1.Repositry.WishListRepositry;
import com.example.demo1.dao.UserDao;

import jakarta.transaction.Transactional;

@Repository
public class UserDaoImplementation implements UserDao {
	@Autowired
	private UserRepositry repositry;

	@Autowired
	private CartRepositry cartRepositry;

	@Autowired
	private WishListRepositry wishListRepositry;

	@Override
	public UserDTO saveUser(UserDTO u) {
		validateUserExistence(u);

		User userEntity = mapToEntity(u);
		User savedUser = repositry.save(userEntity);

		createCartForUser(savedUser);
		createWishListForUser(savedUser);

		return mapToDTO(savedUser);
	}

	private void validateUserExistence(UserDTO u) {
		if (repositry.existsByEmail(u.getEmail())) {
			throw new AlreadyExists("Entity Already Present With The Email: " + u.getEmail());
		}
		if (repositry.existsByPhoneNo(u.getPhoneNo())) {
			throw new AlreadyExists("Entity Already Present With The Phone Number: " + u.getPhoneNo());
		}
	}

	private void createCartForUser(User savedUser) {
		Cart cart = new Cart();
		cart.setUser(savedUser);
		cart.setProductCount(0);
		cartRepositry.save(cart);
	}

	private void createWishListForUser(User savedUser) {
		WishList wishList = new WishList();
		wishList.setUser(savedUser);
		wishListRepositry.save(wishList);
	}

	@Override
	public UserDTO updateUser(int id, UserDTO u) {
		fetchByID(id);
		validateUserUpdate(u, id);

		User userEntity = mapToEntity(u);
		userEntity.setId(id);
		User updatedUser = repositry.save(userEntity);

		return mapToDTO(updatedUser);
	}

	private void validateUserUpdate(UserDTO u, int id) {
		if (repositry.findByEmail(u.getEmail()).filter(user -> user.getId() != id).isPresent()) {
			throw new AlreadyExists("Entity Already Present with the email: " + u.getEmail());
		}
		if (repositry.findByPhoneNo(u.getPhoneNo()).filter(user -> user.getId() != id).isPresent()) {
			throw new AlreadyExists("Entity Already Present with the phone number: " + u.getPhoneNo());
		}
	}

	@Override
	public UserDTO fetchByID(int id) {
		User user = repositry.findById(id).orElseThrow(
				() -> new EntityNotPresentException("Entity with the ID: " + id + " is Not Present in Database"));
		return mapToDTO(user);
	}

	@Override
	public UserDTO fetchByEmail(String email) {
		User user = repositry.findByEmail(email).orElseThrow(
				() -> new EntityNotPresentException("Entity with the email: " + email + " is Not Present in Database"));
		return mapToDTO(user);
	}

	@Override
	public UserDTO fetchByNumber(long phoneNo) {
		User user = repositry.findByPhoneNo(phoneNo).orElseThrow(() -> new EntityNotPresentException(
				"Entity with the Phone Number: " + phoneNo + " is Not Present in Database"));
		return mapToDTO(user);
	}

	@Override
	@Transactional
	public boolean deleteByID(int id) {
		fetchByID(id);
		repositry.deleteById(id);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteByPhoneNo(long phoneNo) {
		fetchByNumber(phoneNo);
		repositry.deleteByPhoneNo(phoneNo);
		return true;
	}

	@Override
	public List<UserDTO> fetchByName(String name) {
		List<User> users = repositry.findByName(name);
		if (users.isEmpty()) {
			throw new EntityNotPresentException("The Given Name: " + name + " Is Not Present in the Database");
		}
		return users.stream().map(this::mapToDTO).toList();
	}

	@Override
	public List<UserDTO> fetchallUser() {
		List<User> allUsers = repositry.findAll();
		return allUsers.stream().map(this::mapToDTO).toList();
	}

	@Override
	public Boolean existByEmail(String email) {
		return repositry.existsByEmail(email);
	}

	@Override
	public Boolean existsByNumber(long phoneNo) {
		return repositry.existsByPhoneNo(phoneNo);
	}

	private User mapToEntity(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setLastname(dto.getLastname());
		user.setEmail(dto.getEmail());
		user.setPhoneNo(dto.getPhoneNo());
		user.setStatus(dto.getStatus());
		user.setRole(dto.getRole());
		user.setDob(dto.getDob());
		user.setGender(dto.getGender());
		user.setAddresses(dto.getAddresses());
		return user;
	}

	private UserDTO mapToDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setLastname(user.getLastname());
		dto.setEmail(user.getEmail());
		dto.setPhoneNo(user.getPhoneNo());
		dto.setStatus(user.getStatus());
		dto.setRole(user.getRole());
		dto.setDob(user.getDob());
		dto.setGender(user.getGender());
		dto.setAddresses(user.getAddresses());
		return dto;
	}
}
