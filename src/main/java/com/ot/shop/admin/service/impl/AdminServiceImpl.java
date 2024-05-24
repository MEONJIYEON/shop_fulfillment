package com.ot.shop.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ot.shop.admin.data.dao.AdminDAO;
import com.ot.shop.admin.data.dto.AdminLoginRequestDTO;
import com.ot.shop.admin.data.dto.NonMemberOrderRequestDTO;
import com.ot.shop.admin.data.dto.ShopToMainDTO;
import com.ot.shop.admin.data.dto.ShopToMainResponseDTO;
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
			/*
			 * orderRequestDto.setName(order.getName());
			 * orderRequestDto.setZipcode(order.getZipcode());
			 * orderRequestDto.setOrderNumber(order.getOrderNumber());
			 * orderRequestDto.setProductName(order.getProduct().getName());
			 * orderRequestDto.setPrice(order.getProduct().getPrice());
			 * orderRequestDto.setCreate_at(order.getCreate_at());
			 * orderRequestDto.setHp1(order.getHp1());
			 * orderRequestDto.setHp2(order.getHp2());
			 * orderRequestDto.setHp3(order.getHp3());
			 * orderRequestDto.setAddress(order.getAddress());
			 * orderRequestDto.setProductCode(order.getProduct().getProductCode());
			 * orderRequestDto.setOrdercount(order.getOrdercount());
			 */
			
			
			
			orderRequestDto.setName(order.getName());
			orderRequestDto.setZipcode(order.getZipcode());
			orderRequestDto.setOrderNumber(order.getOrderNumber());
			orderRequestDto.setProductName(order.getProduct().getProductName());
			orderRequestDto.setPrice(order.getProduct().getPrice());
			orderRequestDto.setCreate_at(order.getCreate_at());
			orderRequestDto.setHp1(order.getHp1());
			orderRequestDto.setHp2(order.getHp2());
			orderRequestDto.setHp3(order.getHp3());
			orderRequestDto.setAddress(order.getAddress());
			orderRequestDto.setProductCode(order.getProduct().getProductCode());
			orderRequestDto.setOrdercount(order.getOrdercount());
			
			
			requestDtoList.add(orderRequestDto);
		}
		
		return requestDtoList;
	}

	@Override
	public AdminLoginRequestDTO login(String id) {
		return adminDAO.login(id);
	}
	
	@Override
	public void shopToMain(ShopToMainDTO shopToMainDTO) {
	    WebClient webClient = WebClient.builder()
	            .baseUrl("http://localhost:9001")
	            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	            .build();

	    System.out.println(shopToMainDTO);

	    ShopToMainResponseDTO shopToMainResponseDTO = new ShopToMainResponseDTO();
	    shopToMainResponseDTO.setUserName(shopToMainDTO.getName());
	    shopToMainResponseDTO.setHp1(shopToMainDTO.getHp1());
	    shopToMainResponseDTO.setHp2(shopToMainDTO.getHp2());
	    shopToMainResponseDTO.setHp3(shopToMainDTO.getHp3());
	    shopToMainResponseDTO.setZipcode(shopToMainDTO.getZipcode());
	    shopToMainResponseDTO.setAddress(shopToMainDTO.getAddress());
	    shopToMainResponseDTO.setOrderCount(shopToMainDTO.getOrderCount());
	    shopToMainResponseDTO.setProductName(shopToMainDTO.getName());
	    shopToMainResponseDTO.setProductCode(shopToMainDTO.getProductCode());

	    webClient.post()
	            .uri("/api/v1/main-fulfillment/productManagement/shopToMain")
	            .bodyValue(shopToMainResponseDTO)
	            .retrieve()
	            .toEntity(ShopToMainResponseDTO.class)
	            .block();
	    

	}


}
