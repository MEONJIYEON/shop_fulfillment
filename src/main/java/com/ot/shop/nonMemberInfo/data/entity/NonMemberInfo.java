package com.ot.shop.nonMemberInfo.data.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "S_NON_MEMBER_INFO")

public class NonMemberInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "non_member_info_seq")
    @SequenceGenerator(name = "non_member_info_seq", sequenceName = "non_member_info_seq", allocationSize = 1)
    @Column(length = 14, nullable = false, unique = true)
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
    private Date createdDate;
    
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
