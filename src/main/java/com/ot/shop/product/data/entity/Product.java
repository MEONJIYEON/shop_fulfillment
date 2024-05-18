package com.ot.shop.product.data.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
