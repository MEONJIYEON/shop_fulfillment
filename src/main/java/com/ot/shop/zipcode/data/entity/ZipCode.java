package com.ot.shop.zipcode.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="zipcode")
@SequenceGenerator(name = "zipcode_seq", sequenceName = "zipcode_seq", allocationSize = 1)
public class ZipCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zipcode_seq")
	private Long id;
	
	@Column(name="zipcode")
	private String zipcode;
	
	@Column(name="cityname")
	private String cityName;
	
	
	@Column(name="regionname")
	private String regionName;
	
	
	@Column(name="streetname")
	private String streetName;
	
	

}
