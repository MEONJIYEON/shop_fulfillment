package com.ot.shop.nonMemberInfo.service;

import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadResponseDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateResponseDTO;

public interface NonMemberInfoService {
	NonMemberInfoCreateResponseDTO saveNonMemberInfo(NonMemberInfoCreateRequestDTO nonMemberInfo, String productCode);
		
	NonMemberInfoReadResponseDTO selectNonMemberInfo(NonMemberInfoReadRequestDTO nonMemberInfoReadRequestDTO);
}
