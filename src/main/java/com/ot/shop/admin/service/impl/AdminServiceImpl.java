package com.ot.shop.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot.shop.admin.data.dao.AdminDAO;
import com.ot.shop.admin.data.dto.AdminLoginRequestDTO;
import com.ot.shop.admin.data.dto.NonMemberOrderRequestDTO;
import com.ot.shop.admin.service.AdminService;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateRequestDTO;
import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;

@Service
public class AdminServiceImpl implements AdminService {

	private final AdminDAO adminDAO;
	
	@Autowired
	public AdminServiceImpl(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public List<NonMemberOrderRequestDTO> findAllOrder() {
		List<NonMemberInfo> orderList = adminDAO.selectAllOrder();
	
		List<NonMemberOrderRequestDTO> requestDtoList = new ArrayList<>();
		
//		private String name;
//		private String zipcode;
//		private String orderNumber;
//		private String productName; // 상품 이름 - product.getName()
//		private String price; // 상품 가격 - product.getPrice()
//		//배송상태
//		
//		private LocalDateTime create_at;

		for(NonMemberInfo order: orderList) {
			NonMemberInfoCreateRequestDTO requestDto = new NonMemberInfoCreateRequestDTO();

//			requestDto.setName(order.getName());
//			requestDto.setHp1(order.getHp1());
//			requestDto.setHp2(order.getHp2());
//			requestDto.setHp3(order.getHp3());
//			requestDto.setZipcode(order.getZipcode());
//			requestDto.setProductCode(order.getProduct().getProductCode());
//			requestDto.setProductName(order.getProduct().getName());
//			requestDto.setOrderCount(order.getOrdercount());
//			requestDto.setCreate_at(order.getCreate_at());

			NonMemberOrderRequestDTO orderRequestDto = new NonMemberOrderRequestDTO();
			orderRequestDto.setName(order.getName());
			orderRequestDto.setZipcode(order.getZipcode());
			orderRequestDto.setOrderNumber(order.getOrderNumber());
			orderRequestDto.setProductName(order.getProduct().getName());
			orderRequestDto.setPrice(order.getProduct().getPrice());
			orderRequestDto.setCreate_at(order.getCreate_at());

			
			requestDtoList.add(orderRequestDto);
		}
		
		return requestDtoList;
	}

	@Override
	public AdminLoginRequestDTO login(String id) {
		return adminDAO.login(id);
	}

}
