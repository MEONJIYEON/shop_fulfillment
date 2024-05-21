package com.ot.shop.product.data.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
	private Long id;
	private String productCode;
	private Integer stock;
	private String name;
	private Integer price;
	private String content;
	private String image;
	private LocalDateTime create_at;
	private LocalDateTime updated_at;


	public void setProductCode(String productCode) {
		 this.productCode = "MON-" + this.id;
		 System.out.println("ProductResponseDto : " +this.getProductCode());    
	}
}
