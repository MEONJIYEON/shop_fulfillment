package com.ot.shop.product.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot.shop.product.controller.ProductController;
import com.ot.shop.product.data.dto.ProductDto;
import com.ot.shop.product.data.dto.ProductResponseDto;
import com.ot.shop.product.data.dto.UpdateProductDto;
import com.ot.shop.product.service.ProductService;

@RestController
@RequestMapping("/api/v1/shop-fulfillment")
public class ProductControllerImpl implements ProductController {
	
	private final ProductService productService;
	
	@Autowired
	public ProductControllerImpl(ProductService productService){
		this.productService = productService;
	}

	@PostMapping()
	public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
		ProductResponseDto productResponseDto = productService.saveProduct(productDto);
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
	}

	@GetMapping()
	public ResponseEntity<ProductResponseDto> getProduct(Long id) {
		ProductResponseDto productResponseDto = productService.getProduct(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
	}

	@PutMapping()
	public ResponseEntity<ProductResponseDto> updateProduct(UpdateProductDto updateProductDto) throws Exception{
		//Long id ,String name, Integer price, String content, String image
		//Long id, String name, String content, String image, Integer price
		
		ProductResponseDto productResponseDto = productService.updateProduct(
				updateProductDto.getId(), updateProductDto.getName(),
				updateProductDto.getContent(), updateProductDto.getImage(), updateProductDto.getPrice());
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
	}

	@DeleteMapping()
	public ResponseEntity<String> deleteProduct(Long id) throws Exception {
		productService.deleteProduct(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("delete");
	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
		List<ProductResponseDto> products = productService.findAllProduct();
		
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
}
