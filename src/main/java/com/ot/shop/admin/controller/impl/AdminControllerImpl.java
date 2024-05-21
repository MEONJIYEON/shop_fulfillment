package com.ot.shop.admin.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot.shop.admin.controller.AdminController;
import com.ot.shop.admin.data.dto.AdminLoginRequestDTO;
import com.ot.shop.admin.service.AdminService;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoRequestDTO;

@RestController
@RequestMapping("/api/v1/shop-fulfillment")
public class AdminControllerImpl implements AdminController {

	private final AdminService adminService;
	
	@Autowired
	public AdminControllerImpl(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("/getAllOrders()")
	public ResponseEntity<List<NonMemberInfoRequestDTO>> getAllOrders() {
		List<NonMemberInfoRequestDTO> orders = adminService.findAllOrder();
		
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}

	@GetMapping("/login()")
	@Override
	//login
	public String login(String id, Model model) {
		
		AdminLoginRequestDTO loginResult = adminService.login(id);
		
		if (loginResult.getId() != null) {
			//login success
			System.out.println("loginResult : " + loginResult);
			model.addAttribute("loginResult", loginResult);
			
			return "next";
		}else {
			//login fail
			System.out.println("loginResult : " + loginResult);
			return "login";
		}
	
	}
}
