package com.ot.shop.nonMemberInfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot.shop.nonMemberInfo.data.dao.impl.NonMemberInfoDAOImpl;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoResponseDTO;
import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;
import com.ot.shop.nonMemberInfo.service.NonMemberInfoService;

@Service
public class NonMemberInfoServiceImpl implements NonMemberInfoService {
	
	private final NonMemberInfoDAOImpl nonMemberInfoDAOImpl;
	
	@Autowired
	public NonMemberInfoServiceImpl(NonMemberInfoDAOImpl nonMemberInfoDAOImpl) {
		this.nonMemberInfoDAOImpl = nonMemberInfoDAOImpl;
	}

	@Override
	public NonMemberInfoRequestDTO saveNonMemberInfo(NonMemberInfo nonMemberInfo) {
		nonMemberInfoDAOImpl.insertNonMemberInfo(nonMemberInfo);
		return null;
	}

	@Override
	public NonMemberInfoResponseDTO getNonMemberInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
} 
