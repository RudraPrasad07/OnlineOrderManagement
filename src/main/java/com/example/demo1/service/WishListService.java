package com.example.demo1.service;

import java.util.List;

import com.example.demo1.DTO.UserDTO;
import com.example.demo1.DTO.WishListDTO;
import com.example.demo1.Utility.ResponseStructure;

public interface WishListService {

	ResponseStructure<WishListDTO> updateList(int id, WishListDTO w);

	ResponseStructure<WishListDTO> findWishListByID(int id);

	ResponseStructure<UserDTO> findByUserEmail(String email);

	ResponseStructure<WishListDTO> addProduct(int Id, int productId);

	ResponseStructure<WishListDTO> removeProduct(int Id, int pId);

	ResponseStructure<List<WishListDTO>> findWishListAll();

}
