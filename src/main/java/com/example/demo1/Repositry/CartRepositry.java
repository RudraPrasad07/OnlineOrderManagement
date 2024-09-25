package com.example.demo1.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.Entity.Cart;

public interface CartRepositry extends JpaRepository<Cart, Integer> {


}
