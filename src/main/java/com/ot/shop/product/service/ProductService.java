package com.ot.shop.product.service;

import java.util.List;

import com.ot.shop.product.data.dto.ProductDTO;
import com.ot.shop.product.data.dto.ProductResponseDTO;

public interface ProductService {
	ProductResponseDTO saveProduct(ProductDTO productDto);
	
	ProductResponseDTO getProduct(Long id);
	
	ProductResponseDTO updateProduct(Long id, String name, String content,Integer stock, String image, Integer price) throws Exception;

	void deleteProduct(Long id) throws Exception;
	
	List<ProductResponseDTO> findAllProduct();
}
