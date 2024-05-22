package com.ot.shop.admin.data.dao;

import java.util.List;

import com.ot.shop.admin.data.dto.AdminLoginRequestDTO;
import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;

public interface AdminDAO {
	
	//회원주문목록
	List<NonMemberInfo> selectAllOrder();
	
	//로그인
	AdminLoginRequestDTO login(String id);
	
	//비회원 주문 정보 확인
}
