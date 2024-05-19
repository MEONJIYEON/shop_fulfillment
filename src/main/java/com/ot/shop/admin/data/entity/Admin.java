package com.ot.shop.admin.data.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "S_Admin")
public class Admin {
	@Id
	private String id;
	
	@Column(nullable = false)
	private String pw;
}
