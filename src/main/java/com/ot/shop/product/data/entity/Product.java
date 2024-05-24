package com.ot.shop.product.data.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "S_Product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@Column(nullable = false, unique = true)
	private Long id;
	
	@Column(nullable = false, name="productcode")
	private String productCode;
	
	public String getProductCode() {
		return productCode;
	}
	
	public void setProductCode(String productCode) {
		System.out.println("====>Product id: " + id);  
		this.productCode = "MON-" + id;
		System.out.println("===>Product : " +this.getProductCode());    
	}
	
	@Column(nullable = false)
	private Integer stock;
	
	@Column(nullable = false, name="productname")
	private String productName;
	
	@Column(nullable = false)
	private Integer price;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private String image;
	
	@Column(nullable = false)
	private LocalDateTime create_at;
	
	private LocalDateTime updated_at;
	
	@PrePersist
    protected void onCreate() {
        create_at = LocalDateTime.now();
        updated_at = LocalDateTime.now();
    }
	
    @PreUpdate
    protected void onUpdate() {
        updated_at = LocalDateTime.now();
    }
    
}
