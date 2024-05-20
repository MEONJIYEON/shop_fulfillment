package com.ot.shop.nonMemberInfo.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.ot.shop.product.data.entity.Product;

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
    @Column(length = 14, nullable = false, name="ordernumber")
    private String orderNumber;
    
    @OneToOne
    @JoinColumn(name = "productcode")
    private Product Product;
    
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String email2;
    
    @Column(nullable = false)
    private String hp1;
    
    @Column(nullable = false)
    private String hp2;
    
    @Column(nullable = false)
    private String hp3;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private String zipcode;
    
    @Column(nullable = false)
    private char aggrement1;
    
    @Column(nullable = false)
    private char aggrement2;
    
    @Column(nullable = false)
    private char aggrement3;
    
    @Column(nullable = false)
    private int ordercount;
    
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
