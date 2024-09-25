package com.example.demo1.serviceImplementation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Entity.Address;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.AddressDao;
import com.example.demo1.service.AddressService;

@Service
public class AddressserviceImplementation implements AddressService {
	@Autowired
	private AddressDao address;

	@Override
	public ResponseStructure<Address> updateAddress(int id, Address a) {
		Address updateAddress = address.updateAddress(a, id);
		return new ResponseStructure<Address>(200, "Data updated Sucessfully in The Database", updateAddress,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Address> fetchById(int id) {
		Address address2 = address.fetchById(id);
		return new ResponseStructure<Address>(200, "Data Fetched Sucessfully from The DataBase", address2,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Address> saveAddress(Address a) {
		Address address2 = address.saveAddress(a);
		return new ResponseStructure<Address>(201, "Data Saved Sucessfully in the Database", address2,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Address> deleteAddress(int id) {
		address.deleteAddress(id);
		return new ResponseStructure<Address>(200, "Data Deleted Sucessfully", null, LocalDateTime.now());
	}

}
