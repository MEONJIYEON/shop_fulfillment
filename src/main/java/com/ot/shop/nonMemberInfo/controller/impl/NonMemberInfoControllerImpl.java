package com.ot.shop.nonMemberInfo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot.shop.nonMemberInfo.controller.NonMemberInfoController;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoResponseDTO;
import com.ot.shop.nonMemberInfo.service.NonMemberInfoService;

@RestController
@RequestMapping("/api/v1/shop-fulfillment")
public class NonMemberInfoControllerImpl implements NonMemberInfoController {
	
	private final NonMemberInfoService nonMemberInfoService;
	
	@Autowired
	public NonMemberInfoControllerImpl(NonMemberInfoService nonMemberInfoService) {
		this.nonMemberInfoService = nonMemberInfoService;
	}
	
	@Override
	@PostMapping("/create")
	public ResponseEntity<NonMemberInfoResponseDTO> createNonMemberInfo(@RequestBody NonMemberInfoCreateRequestDTO nonMemberInfoCreateRequestDTO){
		NonMemberInfoResponseDTO nonMemberInfoCreateResponseDTO = this.nonMemberInfoService.saveNonMemberInfo(nonMemberInfoCreateRequestDTO);
		return ResponseEntity.status(HttpStatus.OK).body(nonMemberInfoCreateResponseDTO);
	}
	
	

}
