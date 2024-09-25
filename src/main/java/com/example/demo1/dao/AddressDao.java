package com.example.demo1.dao;

import com.example.demo1.Entity.*;

public interface AddressDao {
	Address saveAddress(Address a);

	Address updateAddress(Address a, int id);

	Address fetchById(int id);

	boolean deleteAddress(int id);

}
