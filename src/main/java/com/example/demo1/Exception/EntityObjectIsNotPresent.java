package com.example.demo1.Exception;

public class EntityObjectIsNotPresent extends RuntimeException {

	public EntityObjectIsNotPresent(Object msg) {
		super(msg.toString());
	}

}
