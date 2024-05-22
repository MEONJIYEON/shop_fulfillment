package com.ot.shop.nonMemberInfo.controller;

import org.springframework.http.ResponseEntity;

import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateResponseDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadResponseDTO;


public interface NonMemberInfoController {
	ResponseEntity<NonMemberInfoCreateResponseDTO> createNonMemberInfo(NonMemberInfoCreateRequestDTO nonMemberInfoCreateRequestDTO, String productCode);
	ResponseEntity<NonMemberInfoReadResponseDTO> selectNonMemberInfo(NonMemberInfoReadRequestDTO nonMemberInfoReadRequestDTO);

}
