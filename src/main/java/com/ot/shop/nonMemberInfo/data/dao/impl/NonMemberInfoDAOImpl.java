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

	
	
	
	
//	@Override
//	public NonMemberInfo updateNonMemberInfo(NonMemberInfo nonMemberInfo) throws Exception {
//		Optional<NonMemberInfo> selectedNonMemberInfo = nonMemberInfoRepository.findById(nonMemberInfo.getOrderNumber());
//		
//		NonMemberInfo updatedNonMemberInfo;
//		
//		if(selectedNonMemberInfo.isPresent()) {
//			
//			NonMemberInfo requestNonMemberInfo = selectedNonMemberInfo.get();
//			
//			requestNonMemberInfo.setName(nonMemberInfo.getName());
//			requestNonMemberInfo.setEmail(nonMemberInfo.getEmail());
//			requestNonMemberInfo.setEmail2(nonMemberInfo.getEmail2());
//			requestNonMemberInfo.setHp1(nonMemberInfo.getHp1());
//			requestNonMemberInfo.setHp2(nonMemberInfo.getHp2());
//			requestNonMemberInfo.setHp3(nonMemberInfo.getHp3());
//			requestNonMemberInfo.setAddress(nonMemberInfo.getAddress());
//			requestNonMemberInfo.setZipcode(nonMemberInfo.getZipcode());
//			requestNonMemberInfo.setAggrement1(nonMemberInfo.getAggrement1());
//			requestNonMemberInfo.setAggrement2(nonMemberInfo.getAggrement2());
//			requestNonMemberInfo.setAggrement3(nonMemberInfo.getAggrement3());
//			requestNonMemberInfo.setOrdercount(nonMemberInfo.getOrdercount());
//			requestNonMemberInfo.setUpdated_at(nonMemberInfo.getUpdated_at());
//			
//			updatedNonMemberInfo = nonMemberInfoRepository.save(requestNonMemberInfo);
//		
//		} else {
//			updatedNonMemberInfo = new NonMemberInfo();
//		}
//		
//		return updatedNonMemberInfo;
//	}
	
}
