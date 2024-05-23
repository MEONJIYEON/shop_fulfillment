package com.ot.shop.nonMemberInfo.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NonMemberInfoCreateRequestDTO {

	private String orderNumber;	
	
	private String name;
	private String email;
	private String email2;
	private String hp1;
	private String hp2;
	private String hp3;
	private String address;
	private String zipcode;
	
	private String aggrement1;
	private String aggrement2;
	private String aggrement3;
	private int orderCount;	

}