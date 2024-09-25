package com.example.demo1.Repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.Entity.User;

public interface UserRepositry extends JpaRepository<User, Integer> {

	public boolean existsByEmail(String email);

	public boolean existsByPhoneNo(long phoneNo);

	public Optional<User> findByEmail(String email);

	public Optional<User> findByPhoneNo(long phoneNo);

	public List<User> findByName(String name);

	public void deleteByPhoneNo(long phoneNo);
}
