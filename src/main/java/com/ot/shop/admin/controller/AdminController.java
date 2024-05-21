package com.ot.shop.admin.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoRequestDTO;

public interface AdminController {
	ResponseEntity<List<NonMemberInfoRequestDTO>> getAllOrders();
	
	public String login(@RequestParam String id, Model model);
}
