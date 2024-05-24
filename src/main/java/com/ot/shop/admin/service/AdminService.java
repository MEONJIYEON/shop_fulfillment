package com.ot.shop.admin.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ot.shop.admin.data.dto.AdminLoginRequestDTO;
import com.ot.shop.admin.data.dto.NonMemberOrderRequestDTO;
import com.ot.shop.admin.data.dto.ShopToMainDTO;
import com.ot.shop.admin.data.dto.ShopToMainResponseDTO;

public interface AdminService {

	List<NonMemberOrderRequestDTO> findAllOrder();
	AdminLoginRequestDTO login(String id);
	void shopToMain(ShopToMainDTO shopToMainDTO);

}
