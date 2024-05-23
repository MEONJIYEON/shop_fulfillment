package com.ot.shop.nonMemberInfo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ot.shop.nonMemberInfo.controller.NonMemberInfoController;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateResponseDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadResponseDTO;
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

	public ResponseEntity<NonMemberInfoCreateResponseDTO> createNonMemberInfo(@RequestBody NonMemberInfoCreateRequestDTO nonMemberInfoCreateRequestDTO, Long id){
		NonMemberInfoCreateResponseDTO nonMemberInfoCreateResponseDTO = nonMemberInfoService.saveNonMemberInfo(nonMemberInfoCreateRequestDTO, id);

		return ResponseEntity.status(HttpStatus.OK).body(nonMemberInfoCreateResponseDTO);
	}

	@Override
	@GetMapping("/read")
	public ResponseEntity<NonMemberInfoReadResponseDTO> selectNonMemberInfo(NonMemberInfoReadRequestDTO nonMemberInfoReadRequestDTO) {
		NonMemberInfoReadResponseDTO nonMemberInfoReadResponseDTO = nonMemberInfoService.selectNonMemberInfo(nonMemberInfoReadRequestDTO);
		return ResponseEntity.status(HttpStatus.OK).body(nonMemberInfoReadResponseDTO);
	}
	
	

}
