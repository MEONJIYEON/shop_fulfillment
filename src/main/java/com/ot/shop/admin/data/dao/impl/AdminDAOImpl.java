package com.ot.shop.admin.data.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ot.shop.admin.data.dao.AdminDAO;
import com.ot.shop.admin.data.dto.AdminLoginRequestDTO;
import com.ot.shop.admin.data.entity.Admin;
import com.ot.shop.admin.data.repository.AdminRepository;
import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;
import com.ot.shop.nonMemberInfo.data.repository.NonMemberInfoRepository;
import com.ot.shop.product.data.entity.Product;
import com.ot.shop.product.data.repository.ProductRepository;

@Component
public class AdminDAOImpl implements AdminDAO {

	private final NonMemberInfoRepository nonMemberInfoRepository;
	private final AdminRepository adminRepository;
	private final ProductRepository	productRepository;
	
	@Autowired
	public AdminDAOImpl(NonMemberInfoRepository nonMemberInfoRepository
			,AdminRepository adminRepository,
			ProductRepository productRepository) {
		this.nonMemberInfoRepository = nonMemberInfoRepository;
		this.adminRepository = adminRepository;
		this.productRepository = productRepository;
	}
	
	@Override
	public List<NonMemberInfo> selectAllOrder() {
		List<Product> productList = productRepository.findAll();
		
		List<NonMemberInfo> nonMemberInfoList = nonMemberInfoRepository.findAll();
		int index = 0;
		for (NonMemberInfo member : nonMemberInfoList) {
		    if (index < productList.size()) {
		        member.setProduct(productList.get(index));
		        index++;
		    } else {
		        break;
		    }
		}
		
		return nonMemberInfoRepository.findAll();
	}
	
	@Override
	public AdminLoginRequestDTO login(String id) {
		AdminLoginRequestDTO adminRequestDto = new AdminLoginRequestDTO();
		
		Boolean existLogin = adminRepository.existsById(id);
		
		if(existLogin == true) {
			Admin loginInformation = adminRepository.findById(id).get();
			adminRequestDto.setId(loginInformation.getId());
			adminRequestDto.setPw(loginInformation.getPw());
		}
		return adminRequestDto;
	}

}
