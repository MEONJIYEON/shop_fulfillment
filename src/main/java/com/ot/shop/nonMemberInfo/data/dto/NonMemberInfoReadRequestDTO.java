package com.ot.shop.nonMemberInfo.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NonMemberInfoReadRequestDTO {
	private String orderNumber;
	
	private String name;
}
