package com.ot.shop.admin.service;

import java.util.List;

import com.ot.shop.admin.data.dto.AdminLoginRequestDTO;
import com.ot.shop.admin.data.dto.NonMemberOrderRequestDTO;

public interface AdminService {

	List<NonMemberOrderRequestDTO> findAllOrder();
	AdminLoginRequestDTO login(String id);
}
