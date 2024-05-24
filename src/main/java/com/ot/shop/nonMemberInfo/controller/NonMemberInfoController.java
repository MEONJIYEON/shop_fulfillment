package com.ot.shop.nonMemberInfo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateResponseDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadResponseDTO;


public interface NonMemberInfoController {
	
	//Response
	ResponseEntity<NonMemberInfoCreateResponseDTO> createNonMemberInfo(NonMemberInfoCreateRequestDTO nonMemberInfoCreateRequestDTO, String productCode);
	ResponseEntity<NonMemberInfoReadResponseDTO> selectNonMemberInfo(NonMemberInfoReadRequestDTO nonMemberInfoReadRequestDTO);

	
	//index
	ModelAndView showPurchase();
	
	//입력창
	ModelAndView purForm();
	
	//상품 구매하기
	ModelAndView purList(NonMemberInfoCreateRequestDTO nonMemberInfoCreateRequestDTO, String productCode);
	
	//구매 조회하기
	ModelAndView purSearch();
	
	//조회 List화면
	ModelAndView purSearchList(NonMemberInfoReadRequestDTO nonMemberInfoReadRequestDTO);
}
