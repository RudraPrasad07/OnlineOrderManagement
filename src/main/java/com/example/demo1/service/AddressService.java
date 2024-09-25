package com.example.demo1.service;

import com.example.demo1.Entity.Address;
import com.example.demo1.Utility.ResponseStructure;

public interface AddressService {

	ResponseStructure<Address> saveAddress(Address a);

	ResponseStructure<Address> updateAddress(int id, Address a);

	ResponseStructure<Address> fetchById(int id);

	ResponseStructure<Address> deleteAddress(int id);
}
