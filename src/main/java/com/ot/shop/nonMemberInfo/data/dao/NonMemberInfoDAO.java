package com.ot.shop.nonMemberInfo.data.dao;

import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;

public interface NonMemberInfoDAO {
	
	NonMemberInfo insertNonMemberInfo(NonMemberInfo nonMemberInfo, String productCode);
	
	NonMemberInfo readNonMemberInfo(String orderNumber, String name);

	
	
	

}
