package com.ot.shop.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot.shop.admin.data.dao.AdminDAO;
import com.ot.shop.admin.data.dto.AdminLoginRequestDTO;
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
	public List<NonMemberInfoCreateRequestDTO> findAllOrder() {
		List<NonMemberInfo> orderList = adminDAO.selectAllOrder();
		
		List<NonMemberInfoCreateRequestDTO> requestDtoList = new ArrayList<>();
		
		//Dto 값 설정 -> orderList
//		public String name;
//		public String hp1;
//		public String hp2;
//		public String hp3;
//		public String zipcode;
//		public String productCode; //product -> getcode()
//		public String productName; //product -> getName()
//		public Integer orderCount;
//		public LocalDateTime create_at;
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
			
			requestDtoList.add(requestDto);
		}
		
		return requestDtoList;
	}

	@Override
	public AdminLoginRequestDTO login(String id) {
		return adminDAO.login(id);
	}

}
