package com.ot.shop.nonMemberInfo.service;

import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoResponseDTO;
import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;

public interface NonMemberInfoService {
	NonMemberInfoRequestDTO saveNonMemberInfo(NonMemberInfo nonMemberInfo);
	
	NonMemberInfoResponseDTO getNonMemberInfo();
}
