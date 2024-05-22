package com.ot.shop.product.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ot.shop.product.data.dto.ProductDTO;
import com.ot.shop.product.data.dto.UpdateProductDTO;

public interface ProductController {

	public ModelAndView createProduct(@ModelAttribute ProductDTO productDto);

	//ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDto);
	
	//ResponseEntity<ProductResponseDTO> getProduct(Long id);
	
	public ModelAndView getProduct(@RequestParam Long id);
	
	//ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody UpdateProductDTO updateProductDto) throws Exception;

	public ModelAndView updateProduct(@ModelAttribute UpdateProductDTO updateProductDto) throws Exception;
	
	public ModelAndView deleteProduct(Long id) throws Exception;

	//ResponseEntity<List<ProductResponseDTO>> getAllProducts();
	
	public ModelAndView getAllProducts();

	//ResponseEntity<List<ProductResponseDTO>> getAllProducts();

}
