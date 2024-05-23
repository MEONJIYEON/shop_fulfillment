package com.ot.shop.nonMemberInfo.data.dto;

import java.time.LocalDateTime;

import com.ot.shop.product.data.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NonMemberInfoReadResponseDTO {
	//pk
	private String orderNumber;
	
	//비회원 주문자 정보
	private String name;
	private String email;
	private String email2;
	private String hp1;
	private String hp2;
	private String hp3;
	private LocalDateTime create_at;
	private String address;
	private String zipcode;
	private int orderCount;	
	
	//상품정보
	private Product product; 
	
}
