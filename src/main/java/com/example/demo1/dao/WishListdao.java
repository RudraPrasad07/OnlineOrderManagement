package com.example.demo1.dao;

import java.util.List;

import com.example.demo1.DTO.UserDTO;
import com.example.demo1.DTO.WishListDTO;

public interface WishListdao {

	WishListDTO updateList(int id, WishListDTO w);

	WishListDTO findWishListByID(int id);

	UserDTO findByUserEmail(String email);

	WishListDTO addProduct(int Id, int productId);

	WishListDTO removeProduct(int Id, int pId);

	List<WishListDTO> findWishListAll();

}
