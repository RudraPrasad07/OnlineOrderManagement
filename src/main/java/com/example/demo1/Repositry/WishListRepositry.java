package com.example.demo1.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.Entity.WishList;

public interface WishListRepositry extends JpaRepository<WishList, Integer> {

}
