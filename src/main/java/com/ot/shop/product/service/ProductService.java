package com.ot.shop.product.service;

import java.util.List;

import com.ot.shop.product.data.dto.ProductDto;
import com.ot.shop.product.data.dto.ProductResponseDto;

public interface ProductService {
	ProductResponseDto saveProduct(ProductDto productDto);
	
	ProductResponseDto getProduct(Long id);
	
	ProductResponseDto updateProduct(Long id, String name, String content, String image, Integer price) throws Exception;

	void deleteProduct(Long id) throws Exception;
	
	List<ProductResponseDto> findAllProduct();
}
