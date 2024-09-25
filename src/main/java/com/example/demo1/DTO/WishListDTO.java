package com.example.demo1.DTO;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListDTO {
	private int id;
	private UserDTO user;
	private List<ProductDTO> products;

}
