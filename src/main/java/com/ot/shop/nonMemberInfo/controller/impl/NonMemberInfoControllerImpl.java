package com.ot.shop.nonMemberInfo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	public ResponseEntity<NonMemberInfoCreateResponseDTO> createNonMemberInfo(@RequestBody NonMemberInfoCreateRequestDTO nonMemberInfoCreateRequestDTO, String productCode){
		NonMemberInfoCreateResponseDTO nonMemberInfoCreateResponseDTO = nonMemberInfoService.saveNonMemberInfo(nonMemberInfoCreateRequestDTO, productCode);

		return ResponseEntity.status(HttpStatus.OK).body(nonMemberInfoCreateResponseDTO);
	}

	@Override
	@GetMapping("/read")
	public ResponseEntity<NonMemberInfoReadResponseDTO> selectNonMemberInfo(NonMemberInfoReadRequestDTO nonMemberInfoReadRequestDTO) {
		NonMemberInfoReadResponseDTO nonMemberInfoReadResponseDTO = nonMemberInfoService.selectNonMemberInfo(nonMemberInfoReadRequestDTO);
		return ResponseEntity.status(HttpStatus.OK).body(nonMemberInfoReadResponseDTO);
	}
	
	@GetMapping("/purchase")
	@Override
	public ModelAndView showPurchase() {
		ModelAndView mav = new ModelAndView("/shoppingMall/purchase");
		
		return mav;
	}

	@GetMapping("/purForm")
	@Override
	public ModelAndView purForm() {
		ModelAndView mav = new ModelAndView("/shoppingMall/purForm");
		
		return mav;
	}

	@PostMapping("/purList")
	@Override
	public ModelAndView purList(@ModelAttribute NonMemberInfoCreateRequestDTO nonMemberInfoCreateRequestDTO, @RequestParam String productCode) {
		//구매하는 기능 추가
		ModelAndView mav = new ModelAndView("/shoppingMall/purList");
		
		//데이터 저장
		NonMemberInfoCreateResponseDTO insertList = nonMemberInfoService.saveNonMemberInfo(nonMemberInfoCreateRequestDTO, productCode);
		mav.addObject("insertList", insertList);
		return mav;
	}

	@GetMapping("/purSearch")
	@Override
	public ModelAndView purSearch() {
		ModelAndView mav = new ModelAndView("/shoppingMall/purSearch");
		return mav;
	}
	
	@PostMapping("/purSearchList")
	@Override
	public ModelAndView purSearchList(NonMemberInfoReadRequestDTO nonMemberInfoReadRequestDTO) {
		System.out.print("Controller : ====> " + nonMemberInfoReadRequestDTO);
		ModelAndView mav = new ModelAndView("/shoppingMall/purSearchList");
		
		//ordernumber, name 에 맞는 List 가져오기
		NonMemberInfoReadResponseDTO searchList = nonMemberInfoService.selectNonMemberInfo(nonMemberInfoReadRequestDTO);
		mav.addObject("search", searchList);
		System.out.print("Controller searchList : ================>" + searchList);
		
		return mav;
	}
	

}
