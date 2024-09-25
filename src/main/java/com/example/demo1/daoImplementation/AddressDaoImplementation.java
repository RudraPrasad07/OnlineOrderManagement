package com.example.demo1.daoImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo1.Repositry.AddressRepositry;
import com.example.demo1.dao.AddressDao;
import com.example.demo1.Entity.*;
import com.example.demo1.Exception.EntityNotPresentException;

@Repository
public class AddressDaoImplementation implements AddressDao {
	@Autowired
	private AddressRepositry repositry;

	@Override
	public Address fetchById(int id) {
		Optional<Address> optional = repositry.findById(id);
		return optional.orElseThrow(
				() -> new EntityNotPresentException("The Given Id " + id + "Is Not Present In Tha DataBase"));
	}

	@Override
	public Address saveAddress(Address a) {
		return repositry.save(a);
	}

	@Override
	public boolean deleteAddress(int id) {
		Address address = fetchById(id);
		repositry.delete(address);
		return true;
	}

	@Override
	public Address updateAddress(Address a, int id) {
		fetchById(id);
		a.setId(id);
		return repositry.save(a);
	}

}
