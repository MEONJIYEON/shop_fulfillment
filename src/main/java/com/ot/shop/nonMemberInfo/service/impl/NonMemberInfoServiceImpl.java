package com.ot.shop.nonMemberInfo.service.impl;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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
   public NonMemberInfoCreateResponseDTO saveNonMemberInfo(NonMemberInfoCreateRequestDTO nonMemberInfo, String productCode) {
      
	  // orderNumber 생성
	  
	  // ex) 20240523 yyyymmdd 형식 데이터 저장 : formattedDate
	  LocalDateTime nowTime = LocalDateTime.now();
      System.out.println("현재 시간 : ============> " + nowTime);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
      String formattedDate = nowTime.format(formatter);

      System.out.println("formattedDate : ============> " + formattedDate);
      
      // 영문 6자리 랜덤 생성
      
  	  // 사용 가능한 영문 대소문자
      String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
      int codeLength = 6;
      SecureRandom random = new SecureRandom();

      // 랜덤 문자열을 저장할 변수
      StringBuilder enRandomCode = new StringBuilder(codeLength);

      // 6자리 랜덤 문자열 생성
      for (int i = 0; i < codeLength; i++) {
          int index = random.nextInt(characters.length());
          enRandomCode.append(characters.charAt(index));
      }

      // 생성된 랜덤 문자열을 변수에 저장
      String generatedEnCode = enRandomCode.toString();

      // 결과 출력
      System.out.println("Generated Random En Code : ===========> " + generatedEnCode);
	 
      // 최종 orderNumber 
      String orderNumberGene = formattedDate + generatedEnCode;
	  System.out.println("orderNumber 코드 :  ==============> " + orderNumberGene);
      
      
      // ------------------------- -----------------------------
      
	  // Email, hp 나누기
	  String allEmail = nonMemberInfo.getEmail();
	  System.out.println("AllEmail : =========> " + allEmail);	  
	  String emailParts[] = allEmail.split("@");
	  
	  String eamilData1 = emailParts[0];
	  String eamilData2 = emailParts[1];
	  
	  System.out.println("email1 : ========> " + emailParts[0]);
	  System.out.println("email2 : ========> " + emailParts[1]);
	  
	  String allHp = nonMemberInfo.getHp();
	  String[] hpParts = new String[3];
	  
	  hpParts[0] = allHp.substring(0, 3);
	  hpParts[1] = allHp.substring(3, 7);
	  hpParts[2] = allHp.substring(7, 11);
	  
	  String hpData1 = hpParts[0];
	  String hpData2 = hpParts[1];
	  String hpData3 = hpParts[2];
	  
	  System.out.println("hp1 : ========> " + hpData1);
	  System.out.println("hp2 : ========> " + hpData2);
	  System.out.println("hp3 : ========> " + hpData3);
	  
      NonMemberInfo nonInfo = NonMemberInfo.builder()
                   	  .orderNumber(orderNumberGene)
                   	  .name(nonMemberInfo.getName())  
                      .email(eamilData1)
                      .email2(eamilData2)
                      .hp1(hpData1)
                      .hp2(hpData2)
                      .hp3(hpData3)
                      .address(nonMemberInfo.getAddress())
                      .zipcode(nonMemberInfo.getZipcode())
                      .aggrement1(nonMemberInfo.getAggrement1())
                      .aggrement2(nonMemberInfo.getAggrement2())
                      .aggrement3(nonMemberInfo.getAggrement3())
                      .ordercount(nonMemberInfo.getOrderCount())
                      .create_at(LocalDateTime.now())
                      .build();
            
      NonMemberInfo savedNonInfo = nonMemberInfoDAO.insertNonMemberInfo(nonInfo, productCode);
            
      NonMemberInfoCreateResponseDTO nonMemberInfoCreateResponseDTO = new NonMemberInfoCreateResponseDTO();
      
      nonMemberInfoCreateResponseDTO.setOrderNumber(savedNonInfo.getOrderNumber());
      nonMemberInfoCreateResponseDTO.setName(savedNonInfo.getName());
      nonMemberInfoCreateResponseDTO.setEmail(savedNonInfo.getEmail()+savedNonInfo.getEmail2());
      nonMemberInfoCreateResponseDTO.setHp(savedNonInfo.getHp1()+"-"+savedNonInfo.getHp2()+"-"+savedNonInfo.getHp3());
      nonMemberInfoCreateResponseDTO.setAddress(savedNonInfo.getAddress());
      nonMemberInfoCreateResponseDTO.setZipcode(savedNonInfo.getZipcode());
      nonMemberInfoCreateResponseDTO.setOrderCount(savedNonInfo.getOrdercount());
      nonMemberInfoCreateResponseDTO.setProduct(savedNonInfo.getProduct());
      nonMemberInfoCreateResponseDTO.setCreate_at(savedNonInfo.getCreate_at());
      
      
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
      responseInfoDTO.setProduct(selectedNonMemberInfo.getProduct());
      
     System.out.println("NonMemberService : ==========>" + responseInfoDTO);
      
      return responseInfoDTO;
      
   }

   
   
   

   
} 