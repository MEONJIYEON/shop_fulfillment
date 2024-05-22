package com.ot.shop.nonMemberInfo.service;

import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoResponseDTO;

public interface NonMemberInfoService {
	NonMemberInfoResponseDTO saveNonMemberInfo(NonMemberInfoCreateRequestDTO nonMemberInfo);
		
//	NonMemberInfoResponseDTO readNonMemberInfo(NonMemberInfoReadRequestDto nonMemberInfoReadRequestDto);
}
