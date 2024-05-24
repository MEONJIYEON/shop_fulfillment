package com.ot.shop.nonMemberInfo.data.dto;

import java.time.LocalDateTime;

import com.ot.shop.product.data.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NonMemberInfoCreateResponseDTO {
	
	private String orderNumber;
	
	private String name;
	private String email;
	private String hp;
	private String address;
	private String zipcode;
	
	private int orderCount;	
	
	private Product product; 
	private LocalDateTime create_at;

}	
