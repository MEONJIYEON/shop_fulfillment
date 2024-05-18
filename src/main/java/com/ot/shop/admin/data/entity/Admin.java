package com.ot.shop.admin.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "S_Admin")
public class Admin {
	@Id
	@Column(nullable = false, unique = true)
	private String id;
	
	@Column(nullable = false)
	private String pw;
}
