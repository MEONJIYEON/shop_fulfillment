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

@Component
public class AdminDAOImpl implements AdminDAO {

	private final NonMemberInfoRepository nonMemberInfoRepository;
	private final AdminRepository adminRepository;
	
	@Autowired
	public AdminDAOImpl(NonMemberInfoRepository nonMemberInfoRepository
			,AdminRepository adminRepository) {
		this.nonMemberInfoRepository = nonMemberInfoRepository;
		this.adminRepository = adminRepository;
	}
	
	@Override
	public List<NonMemberInfo> selectAllOrder() {
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
