package com.ot.shop.admin.service;

import java.util.List;

import com.ot.shop.admin.data.dto.AdminLoginRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateRequestDTO;

public interface AdminService {

	List<NonMemberInfoCreateRequestDTO> findAllOrder();
	
	AdminLoginRequestDTO login(String id);
}
