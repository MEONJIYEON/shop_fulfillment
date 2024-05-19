package com.ot.shop.product.data.entity;

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

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "S_Product")
@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@Column(nullable = false, unique = true)
	private Long id;
	
	@Column(nullable = false)
	private String productCode;
	
	public String getProductCode() {
		return "MON-" + id;
	}
	
	@Column(nullable = false)
	private Long stock;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Long price;
	
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
