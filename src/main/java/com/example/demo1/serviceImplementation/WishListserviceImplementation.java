package com.example.demo1.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.DTO.WishListDTO;
import com.example.demo1.DTO.UserDTO;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.WishListdao;
import com.example.demo1.service.WishListService;

@Service
public class WishListserviceImplementation implements WishListService {
    @Autowired
    private WishListdao dao;

    @Override
    public ResponseStructure<WishListDTO> updateList(int id, WishListDTO w) {
        WishListDTO list = dao.updateList(id, w);
        return new ResponseStructure<>(200, "Entity Updated Successfully In The DataBase", list,
                LocalDateTime.now());
    }

    @Override
    public ResponseStructure<WishListDTO> findWishListByID(int id) {
        WishListDTO list = dao.findWishListByID(id);
        return new ResponseStructure<>(200, "Entity Fetched Successfully From The Database", list,
                LocalDateTime.now());
    }

    @Override
    public ResponseStructure<UserDTO> findByUserEmail(String email) {
        UserDTO user = dao.findByUserEmail(email);
        return new ResponseStructure<>(200, "Entity Fetched Successfully From The DataBase", user,
                LocalDateTime.now());
    }

    @Override
    public ResponseStructure<WishListDTO> addProduct(int Id, int productId) {
        WishListDTO product = dao.addProduct(Id, productId);
        return new ResponseStructure<>(201, "Product Added Successfully To Wishlist", product,
                LocalDateTime.now());
    }

    @Override
    public ResponseStructure<WishListDTO> removeProduct(int Id, int pId) {
        WishListDTO wishList = dao.removeProduct(Id, pId);
        return new ResponseStructure<>(204, "Product Removed Successfully From The Wishlist", wishList,
                LocalDateTime.now());
    }

    @Override
    public ResponseStructure<List<WishListDTO>> findWishListAll() {
        List<WishListDTO> list = dao.findWishListAll();
        return new ResponseStructure<>(200, "All Wishlists Fetched Successfully", list,
                LocalDateTime.now());
    }
}
