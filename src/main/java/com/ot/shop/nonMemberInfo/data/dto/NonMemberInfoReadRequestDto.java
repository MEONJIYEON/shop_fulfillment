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
public class NonMemberInfoReadRequestDto {
	private String orderNumber;
	
	private String name;
}
