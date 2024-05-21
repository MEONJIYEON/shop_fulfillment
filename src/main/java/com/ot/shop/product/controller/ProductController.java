package com.ot.shop.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.ot.shop.product.data.dto.ProductDTO;
import com.ot.shop.product.data.dto.ProductResponseDTO;
import com.ot.shop.product.data.dto.UpdateProductDTO;

public interface ProductController {
	ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDto);
	
	ResponseEntity<ProductResponseDTO> getProduct(Long id);
	
	ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody UpdateProductDTO updateProductDto) throws Exception;

	ResponseEntity<String> deleteProduct(Long id) throws Exception;
	
	ResponseEntity<List<ProductResponseDTO>> getAllProducts();
}
