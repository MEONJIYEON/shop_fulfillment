package com.ot.shop.nonMemberInfo.data.dao;

import java.util.List;

import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;

public interface NonMemberInfoDAO {
	
	NonMemberInfo insertNonMemberInfo(NonMemberInfo nonmemberinfo, String productCode);
	
	NonMemberInfo readNonMemberInfo(String orderNumber, String name);

	
	
	

}
