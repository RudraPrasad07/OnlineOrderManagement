package com.example.demo1.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.Entity.Address;

public interface AddressRepositry extends JpaRepository<Address, Integer> {

}
