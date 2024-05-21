package com.ot.shop.nonMemberInfo.data.dto;

import com.ot.shop.product.data.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NonMemberInfoRequestDTO {

	private String orderNumber;
	
	private Product Product;
	private String name;
	private String email;
	private String email2;
	private String hp1;
	private String hp2;
	private String hp3;
	private String address;
	private String zipcode;
	
	private char aggrement1;
	private char aggrement2;
	private char aggrement3;
	private int orderCount;	

}