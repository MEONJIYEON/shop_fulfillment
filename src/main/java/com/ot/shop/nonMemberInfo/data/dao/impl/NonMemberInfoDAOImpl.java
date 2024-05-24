package com.ot.shop.nonMemberInfo.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ot.shop.nonMemberInfo.data.dao.NonMemberInfoDAO;
import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;
import com.ot.shop.nonMemberInfo.data.repository.NonMemberInfoRepository;
import com.ot.shop.product.data.entity.Product;
import com.ot.shop.product.data.repository.ProductRepository;

@Component
public class NonMemberInfoDAOImpl implements NonMemberInfoDAO {
	
	private final NonMemberInfoRepository nonMemberInfoRepository;
	
	private ProductRepository productRepository;
	
	@Autowired
	public NonMemberInfoDAOImpl(NonMemberInfoRepository nonMemberInfoRepository, ProductRepository productRepository) {
		this.nonMemberInfoRepository = nonMemberInfoRepository;
		this.productRepository = productRepository;
	}
	
	@Override
	public NonMemberInfo insertNonMemberInfo(NonMemberInfo nonMemberInfo, String productCode) {
		Product product = productRepository.findByProductCode(productCode);		
		nonMemberInfo.setProduct(product);
		
		NonMemberInfo savedNonMemberInfo = nonMemberInfoRepository.save(nonMemberInfo);
		
		return savedNonMemberInfo;
	}

	@Override
	public NonMemberInfo readNonMemberInfo(String orderNumber, String name) {
		return nonMemberInfoRepository.findByOrderNumberAndName(orderNumber, name);
	}

	
}
