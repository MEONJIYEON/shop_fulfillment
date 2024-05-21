package com.ot.shop.nonMemberInfo.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;

public interface NonMemberInfoRepository extends JpaRepository<NonMemberInfo, String>  {

}
