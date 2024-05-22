package com.ot.shop.product.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ot.shop.product.controller.ProductController;
import com.ot.shop.product.data.dto.ProductDTO;
import com.ot.shop.product.data.dto.ProductResponseDTO;
import com.ot.shop.product.data.dto.UpdateProductDTO;
import com.ot.shop.product.service.ProductService;

@RestController
@RequestMapping("/api/v1/shop-fulfillment")
public class ProductControllerImpl implements ProductController {
	
	private final ProductService productService;
	
	@Autowired
	public ProductControllerImpl(ProductService productService){
		this.productService = productService;
	}

//	@PostMapping("/createProduct")
//	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDto) {
//		ProductResponseDTO productResponseDto = productService.saveProduct(productDto);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
//	}
	
	@PostMapping("/createProduct")
    public ModelAndView createProduct(@ModelAttribute ProductDTO productDto) {
        ProductResponseDTO productResponseDto = productService.saveProduct(productDto);
     
        ModelAndView mav = new ModelAndView();
        mav.addObject("productResponse", productResponseDto);
        mav.setViewName("redirect:/api/v1/shop-fulfillment/selectAllProduct");
        return mav;
    }

//	@PostMapping()
//	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDto) {
//		ProductResponseDTO productResponseDto = productService.saveProduct(productDto);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
//	}


//	@GetMapping()
//	public ResponseEntity<ProductResponseDTO> getProduct(Long id) {
//		ProductResponseDTO productResponseDto = productService.getProduct(id);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
//	}
	
	@GetMapping("/getProduct")
	public ModelAndView getProduct(@RequestParam Long id) {
		System.out.println(id);
		ProductResponseDTO productResponseDto = productService.getProduct(id);
		System.out.println(productResponseDto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productResponseDto", productResponseDto);
		mav.setViewName("updateProduct");
		
		return mav;
	}

//	@PutMapping()
//	public ResponseEntity<ProductResponseDTO> updateProduct(UpdateProductDTO updateProductDto) throws Exception{
//		//Long id ,String name, Integer price, String content, String image
//		//Long id, String name, String content, String image, Integer price
//		
//		ProductResponseDTO productResponseDto = productService.updateProduct(
//				updateProductDto.getId(), updateProductDto.getName(),
//				updateProductDto.getContent(), updateProductDto.getImage(), updateProductDto.getPrice());
//		
//		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
//	}
	
	@PostMapping("/updateProduct")
	public ModelAndView updateProduct(@ModelAttribute UpdateProductDTO updateProductDto) throws Exception{
		//Long id ,String name, Integer price, String content, String image
		//Long id, String name, String content, String image, Integer price
		//Long id, String name, String content,Integer stock, String image, Integer price
		System.out.println(updateProductDto);
		ProductResponseDTO productResponseDto = productService.updateProduct(
				updateProductDto.getId(), updateProductDto.getName(),
				updateProductDto.getContent(), updateProductDto.getStock(),
				updateProductDto.getImage(), updateProductDto.getPrice());
		
		System.out.println("=====" + productResponseDto);
		 ModelAndView mav = new ModelAndView();
	     mav.addObject("productResponseDto", productResponseDto);
	     mav.setViewName("redirect:/api/v1/shop-fulfillment/selectAllProduct");
		
	     return mav;
	}

	@PostMapping("/deleteProduct")
	public ModelAndView deleteProduct(Long id) throws Exception {
		productService.deleteProduct(id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/api/v1/shop-fulfillment/selectAllProduct");
		
		return mav;
	}

	//전체 List 가져오기
	/*
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
		List<ProductResponseDTO> products = productService.findAllProduct();
		
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	*/
	
	@GetMapping("/getAllProducts")
	public ModelAndView getAllProducts() {
	    List<ProductResponseDTO> products = productService.findAllProduct();
	    
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("products", products);
	    mav.setViewName("selectAllProduct"); // 렌더링할 뷰의 이름
	    
	    return mav;
	}

	
}
