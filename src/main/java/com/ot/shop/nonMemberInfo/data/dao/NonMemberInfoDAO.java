package com.ot.shop.nonMemberInfo.data.dao;

import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;
import com.ot.shop.product.data.entity.Product;

public interface NonMemberInfoDAO {
	
	NonMemberInfo insertNonMemberInfo(NonMemberInfo nonmemberinfo);
	
	NonMemberInfo selectNonMemberInfo(String orderNumber);

	NonMemberInfo updateNonMemberInfo(NonMemberInfo nonMemberInfo) throws Exception;
	
	void deleteNonMemberInfo(String orderNumber) throws Exception;
	
	

}
