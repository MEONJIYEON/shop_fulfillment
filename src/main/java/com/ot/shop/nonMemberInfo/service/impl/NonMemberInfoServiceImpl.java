package com.ot.shop.nonMemberInfo.service.impl;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot.shop.nonMemberInfo.data.dao.NonMemberInfoDAO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoCreateResponseDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadRequestDTO;
import com.ot.shop.nonMemberInfo.data.dto.NonMemberInfoReadResponseDTO;
import com.ot.shop.nonMemberInfo.data.entity.NonMemberInfo;
import com.ot.shop.nonMemberInfo.service.NonMemberInfoService;

@Service
public class NonMemberInfoServiceImpl implements NonMemberInfoService {
   
   private final NonMemberInfoDAO nonMemberInfoDAO;
   
   @Autowired
   public NonMemberInfoServiceImpl(NonMemberInfoDAO nonMemberInfoDAO) {
      this.nonMemberInfoDAO = nonMemberInfoDAO;
   }

   @Override
   public NonMemberInfoCreateResponseDTO saveNonMemberInfo(NonMemberInfoCreateRequestDTO nonMemberInfo, Long id) {
      
      
      NonMemberInfo nonInfo = NonMemberInfo.builder()
                   .orderNumber(nonMemberInfo.getOrderNumber())
                   .name(nonMemberInfo.getName())  
                      .email(nonMemberInfo.getEmail())
                      .email2(nonMemberInfo.getEmail2())
                      .hp1(nonMemberInfo.getHp1())
                      .hp2(nonMemberInfo.getHp2())
                      .hp3(nonMemberInfo.getHp3())
                      .address(nonMemberInfo.getAddress())
                      .zipcode(nonMemberInfo.getZipcode())
                      .aggrement1(nonMemberInfo.getAggrement1())
                      .aggrement2(nonMemberInfo.getAggrement2())
                      .aggrement3(nonMemberInfo.getAggrement3())
                      .ordercount(nonMemberInfo.getOrderCount())
                      .create_at(LocalDateTime.now())
                      .build();
   
      
      NonMemberInfo savedNonInfo = nonMemberInfoDAO.insertNonMemberInfo(nonInfo, id);
      
      System.out.print("NonMemberInfoService ===========>" + savedNonInfo.getProduct());
      
      NonMemberInfoCreateResponseDTO nonMemberInfoCreateResponseDTO = new NonMemberInfoCreateResponseDTO();
      
      nonMemberInfoCreateResponseDTO.setOrderNumber(savedNonInfo.getOrderNumber());
      nonMemberInfoCreateResponseDTO.setName(savedNonInfo.getName());
      nonMemberInfoCreateResponseDTO.setEmail(savedNonInfo.getEmail());
      nonMemberInfoCreateResponseDTO.setEmail2(savedNonInfo.getEmail2());
      nonMemberInfoCreateResponseDTO.setHp1(savedNonInfo.getHp1());
      nonMemberInfoCreateResponseDTO.setHp2(savedNonInfo.getHp2());
      nonMemberInfoCreateResponseDTO.setHp3(savedNonInfo.getHp3());
      nonMemberInfoCreateResponseDTO.setAddress(savedNonInfo.getAddress());
      nonMemberInfoCreateResponseDTO.setZipcode(savedNonInfo.getZipcode());
      nonMemberInfoCreateResponseDTO.setOrderCount(savedNonInfo.getOrdercount());
      nonMemberInfoCreateResponseDTO.setProduct(savedNonInfo.getProduct());

      
      return nonMemberInfoCreateResponseDTO;
   
   }

   
   @Override
   public NonMemberInfoReadResponseDTO selectNonMemberInfo(NonMemberInfoReadRequestDTO nonMemberInfoReadRequestDTO) {
      NonMemberInfo selectedNonMemberInfo = new NonMemberInfo();
      
      selectedNonMemberInfo = nonMemberInfoDAO.readNonMemberInfo(nonMemberInfoReadRequestDTO.getOrderNumber(), nonMemberInfoReadRequestDTO.getName());
            
      NonMemberInfoReadResponseDTO responseInfoDTO = new NonMemberInfoReadResponseDTO();
      responseInfoDTO.setOrderNumber(selectedNonMemberInfo.getOrderNumber());
      responseInfoDTO.setName(selectedNonMemberInfo.getName());
      responseInfoDTO.setEmail(selectedNonMemberInfo.getEmail());
      responseInfoDTO.setEmail2(selectedNonMemberInfo.getEmail2());
      responseInfoDTO.setHp1(selectedNonMemberInfo.getHp1());
      responseInfoDTO.setHp2(selectedNonMemberInfo.getHp2());
      responseInfoDTO.setHp3(selectedNonMemberInfo.getHp3());
      responseInfoDTO.setCreate_at(selectedNonMemberInfo.getCreate_at());
      responseInfoDTO.setAddress(selectedNonMemberInfo.getAddress());
      responseInfoDTO.setZipcode(selectedNonMemberInfo.getZipcode());
      responseInfoDTO.setOrderCount(selectedNonMemberInfo.getOrdercount());
      
      return responseInfoDTO;
      
   }

   
   
   

   
} 