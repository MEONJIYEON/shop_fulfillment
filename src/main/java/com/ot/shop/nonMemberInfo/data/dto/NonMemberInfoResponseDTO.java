package com.ot.shop.nonMemberInfo.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NonMemberInfoResponseDTO {
	private String orderNumber;
	private String name;
	private String hp1;
	private String hp2;
	private String hp3;

}
