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
	
	private Integer price; 
	
	private String name;
	
	private String hp1;
	
	private String hp2;
	
	private String hp3;
	
	private String zipcode;
	
	private String address;
	
	private String productCode;

	private String productName;
	
	private String orderNumber;
	
    private int ordercount;
    
    private LocalDateTime create_at;
	
}
