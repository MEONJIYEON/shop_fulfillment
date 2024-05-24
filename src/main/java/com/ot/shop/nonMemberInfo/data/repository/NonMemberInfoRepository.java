package com.ot.shop.nonMemberInfo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;

public interface NonMemberInfoRepository extends JpaRepository<NonMemberInfo, String>  {
    NonMemberInfo findByOrderNumberAndName(String orderNumber, String name);

}
