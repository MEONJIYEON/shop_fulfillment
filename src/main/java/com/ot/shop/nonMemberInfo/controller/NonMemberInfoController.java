package com.ot.shop.nonMemberInfo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoResponseDTO;

public interface NonMemberInfoController {
	ResponseEntity<NonMemberInfoResponseDTO> createNonMemberInfo(NonMemberInfoRequestDTO nonMemberInfoCreateRequestDTO);
	
}
