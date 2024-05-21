package com.ot.shop.nonMemberInfo.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot.shop.nonMemberInfo.data.dao.NonMemberInfoDAO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadRequestDto;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoResponseDTO;
import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;
import com.ot.shop.nonMemberInfo.service.NonMemberInfoService;
import com.ot.shop.product.data.entity.Product;

@Service
public class NonMemberInfoServiceImpl implements NonMemberInfoService {
	
	private final NonMemberInfoDAO nonMemberInfoDAO;
	
	@Autowired
	public NonMemberInfoServiceImpl(NonMemberInfoDAO nonMemberInfoDAO) {
		this.nonMemberInfoDAO = nonMemberInfoDAO;
	}

	@Override
	public NonMemberInfoResponseDTO saveNonMemberInfo(NonMemberInfoCreateRequestDTO nonMemberInfo) {
		//		Product product = Product.builder()
		//						 .name(nonMemberInfo.getProduct().getName())
		//						 .stock(nonMemberInfo.getProduct().getStock())
		//						 .price(nonMemberInfo.getProduct().getPrice())
		//						 .build();
		Product product = new Product();
		NonMemberInfo nonInfo = NonMemberInfo.builder()
						 .orderNumber(nonMemberInfo.getOrderNumber())
						 .name(nonMemberInfo.getName())  // nonMemberInfo.getName()
			             .email(nonMemberInfo.getEmail())
			             .email2(nonMemberInfo.getEmail2())
			             .hp1(nonMemberInfo.getHp1())
			             .hp2(nonMemberInfo.getHp2())
			             .hp3(nonMemberInfo.getHp3())
			             .address(nonMemberInfo.getAddress())
			             .zipcode(nonMemberInfo.getZipcode())
			             .aggrement1(nonMemberInfo.getAggrement1())
			             .aggrement2(nonMemberInfo.getAggrement2())
			             .aggrement3(nonMemberInfo.getAggrement3())
			             .ordercount(nonMemberInfo.getOrderCount())
			             .create_at(LocalDateTime.now())
			             .Product(product)
			             .build();
		
		NonMemberInfo savedNonInfo = nonMemberInfoDAO.insertNonMemberInfo(nonInfo);
				
		NonMemberInfoResponseDTO nonMemberInfoCreateResponseDTO = new NonMemberInfoResponseDTO();
		nonMemberInfoCreateResponseDTO.setOrderNumber(savedNonInfo.getOrderNumber());
		
		

		return nonMemberInfoCreateResponseDTO;
	
	}

	
//	@Override
//	public NonMemberInfoResponseDTO readNonMemberInfo(NonMemberInfoReadRequestDto nonMemberInfoReadRequestDto) {
//		NonMemberInfo nonMemberInfo = nonMemberInfoDAO.selectNonMemberInfo(nonMemberInfoReadRequestDto);
//		
//		
//		return null;
//	}

	
	
	

	
} 
