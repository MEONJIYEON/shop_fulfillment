package com.ot.shop.nonMemberInfo.data.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NonMemberInfoReadResponseDTO {
	private String name;
	
	private Integer price;
	
	private Integer stock;
}
