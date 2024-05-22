package com.ot.shop.admin.data.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NonMemberOrderRequestDTO {
	//비회원 주문 정보 확인
	//이름, 주소, 주문번호, 상품 이름, 상품 가격, 배송 상태, 주문 날짜
	
	private String name;
	private String zipcode;
	private String orderNumber;
	private String productName; // 상품 이름 - product.getName()
	private Integer price; // 상품 가격 - product.getPrice()
	//배송상태
	
	private LocalDateTime create_at;
	
	
}
