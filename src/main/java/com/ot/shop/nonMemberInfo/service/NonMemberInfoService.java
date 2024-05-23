package com.ot.shop.nonMemberInfo.service;

import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateResponseDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadResponseDTO;


public interface NonMemberInfoService {

	NonMemberInfoCreateResponseDTO saveNonMemberInfo(NonMemberInfoCreateRequestDTO nonMemberInfo, String productCode);

	NonMemberInfoReadResponseDTO selectNonMemberInfo(NonMemberInfoReadRequestDTO nonMemberInfoReadRequestDTO);
}
