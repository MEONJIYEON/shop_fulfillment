package com.ot.shop.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.ot.shop.product.data.dto.ProductDto;
import com.ot.shop.product.data.dto.ProductResponseDto;
import com.ot.shop.product.data.dto.UpdateProductDto;

public interface ProductController {
	ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto);
	
	ResponseEntity<ProductResponseDto> getProduct(Long id);
	
	ResponseEntity<ProductResponseDto> updateProduct(@RequestBody UpdateProductDto updateProductDto) throws Exception;

	ResponseEntity<String> deleteProduct(Long id) throws Exception;
	
	ResponseEntity<List<ProductResponseDto>> getAllProducts();
}
