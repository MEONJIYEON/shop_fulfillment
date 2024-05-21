package com.ot.shop.nonMemberInfo.service;

import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoResponseDTO;

public interface NonMemberInfoService {
	NonMemberInfoResponseDTO saveNonMemberInfo(NonMemberInfoRequestDTO nonMemberInfo);
		
//	NonMemberInfoResponseDTO readNonMemberInfo(NonMemberInfoReadRequestDto nonMemberInfoReadRequestDto);
}
