package com.ot.shop.admin.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ot.shop.admin.data.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>{

}
