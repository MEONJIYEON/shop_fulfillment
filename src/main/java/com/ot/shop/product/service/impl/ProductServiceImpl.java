package com.ot.shop.product.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot.shop.product.data.dao.ProductDAO;
import com.ot.shop.product.data.dto.ProductDTO;
import com.ot.shop.product.data.dto.ProductResponseDTO;
import com.ot.shop.product.data.entity.Product;
import com.ot.shop.product.data.repository.ProductRepository;
import com.ot.shop.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductDAO productDAO;
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductDAO productDAO, ProductRepository productRepository) {
		this.productDAO = productDAO;
		this.productRepository = productRepository;
	}

	public long getProductCount() {
		 Long id = productRepository.count() + 1;
	     return id;
	}
	 
	@Override
	public ProductResponseDTO saveProduct(ProductDTO productDto) {
		//Product product = new Product();
//		private String productCode;
//		private Integer stock;
//		private String name;
//		private Integer price;
//		private String content;
//		private String image;
//		private LocalDateTime create_at;
		Long nextId = getProductCount();
		
		Product product = Product.builder()
				.id(nextId)
			    .productCode("MON-" + nextId)
			    .stock(productDto.getStock())
			    .productName(productDto.getName())
			    .price(productDto.getPrice())
			    .content(productDto.getContent())
			    .image(productDto.getImage())
			    .create_at(productDto.getCreate_at())
			    .build();
		
		product.setProductCode(productDto.getProductCode());
		product.setStock(productDto.getStock());
		product.setProductName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setContent(productDto.getContent());
		product.setImage(productDto.getImage());
		product.setCreate_at(LocalDateTime.now());
		
		System.out.println("productCode : " + product.getProductCode());
		Product savedProduct = productDAO.insertProduct(product);
		System.out.println("savedProduct : " + savedProduct.getProductCode());
//		private Long id;
//		private String productCode;
//		private Integer stock;
//		private String name;
//		private Integer price;
//		private String content;
//		private String image;
//		private LocalDateTime create_at;
//		private LocalDateTime updated_at;
		
		ProductResponseDTO productResponseDto = new ProductResponseDTO();
		productResponseDto.setId(savedProduct.getId());
		productResponseDto.setProductCode(savedProduct.getProductCode());
		productResponseDto.setStock(savedProduct.getStock());
		productResponseDto.setName(savedProduct.getProductName());
		productResponseDto.setPrice(savedProduct.getPrice());
		productResponseDto.setContent(savedProduct.getContent());
		productResponseDto.setImage(savedProduct.getImage());

		return productResponseDto;
	}

	@Override
	public ProductResponseDTO getProduct(Long id) {
		Product product = productDAO.selectOneProduct(id);
		
		ProductResponseDTO productResponseDto = new ProductResponseDTO();
		
		productResponseDto.setId(product.getId());
		productResponseDto.setProductCode(product.getProductCode());
		productResponseDto.setStock(product.getStock());
		productResponseDto.setName(product.getProductName());
		productResponseDto.setPrice(product.getPrice());
		productResponseDto.setContent(product.getContent());
		productResponseDto.setImage(product.getImage());
		productResponseDto.setCreate_at(product.getCreate_at());
		productResponseDto.setUpdated_at(product.getUpdated_at());
		
		System.out.println(productResponseDto);
		return productResponseDto;
	}

	@Override
	public ProductResponseDTO updateProduct(Long id, String name, String content,Integer stock, String image, Integer price) throws Exception {
		Product changedProduct = productDAO.updateProduct(id, name, content, stock, image, price);
		ProductResponseDTO productResponseDto = new ProductResponseDTO();
		
		productResponseDto.setId(changedProduct.getId());
		productResponseDto.setName(changedProduct.getProductName());
		productResponseDto.setContent(changedProduct.getContent());
		productResponseDto.setImage(changedProduct.getImage());
		productResponseDto.setPrice(changedProduct.getPrice());
		
		System.out.println("updateProduct :" + productResponseDto);
		return productResponseDto;
	}

	@Override
	public void deleteProduct(Long id) throws Exception {
		productDAO.deleteProduct(id);
	}

	@Override
	public List<ProductResponseDTO> findAllProduct() {
		List<Product> productList = productDAO.selectAllProduct();
		
		List<ProductResponseDTO> responseDtoList = new ArrayList<>();

		for (Product product : productList) {
		        ProductResponseDTO responseDto = new ProductResponseDTO();
		        responseDto.setId(product.getId());
		        responseDto.setProductCode(product.getProductCode());
		        responseDto.setStock(product.getStock());
		        responseDto.setName(product.getProductName());
		        responseDto.setPrice(product.getPrice());
		        responseDto.setContent(product.getContent());
		        responseDto.setImage(product.getImage());
		        responseDto.setCreate_at(product.getCreate_at());
		        responseDto.setUpdated_at(product.getUpdated_at());
		        
		        responseDtoList.add(responseDto);
		   }
		    
		return responseDtoList;
	}


}
