package com.ot.shop.nonMemberInfo.data.entity;

import java.sql.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "S_Non_member_info")
public class NonMemberInfo {
	
	@Id
	@Column(length=14, nullable = false, unique = true)
	private String orderNumber;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String email2;
	
	@Column(nullable = false)
	private int hp1;
	
	@Column(nullable = false)
	private int hp2;
	
	@Column(nullable = false)
	private int hp3;
	
	@Column(nullable = false)
	private Date sysdate;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private int zipcode;
	
	@Column(nullable = false)
	private char aggrement1;
	
	@Column(nullable = false)
	private char aggrement2;
	
	@Column(nullable = false)
	private char aggrement3;
	
	@Column(nullable = false)
	private int orderCount;
	
	
	
}
