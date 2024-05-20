package com.ot.shop.product.data.dao.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ot.shop.product.data.dao.ProductDAO;
import com.ot.shop.product.data.entity.Product;
import com.ot.shop.product.data.repository.ProductRepository;

@Component
public class ProductDAOImpl implements ProductDAO {

	private final ProductRepository productRepository;
	
	public ProductDAOImpl(ProductRepository productRepository) {
		this.productRepository = productRepository; 	
	}
	
	@Override
	public Product insertProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public Product selectOneProduct(Long id) {
		Product selectedProduct = productRepository.getById(id);
		return selectedProduct;
	}

	@Override
	public Product updateProduct(Long id, String name, String content, String image, Integer price) throws Exception {
		Optional<Product> selectedProduct = productRepository.findById(id);
		
		Product updatedProduct;
		
		if(selectedProduct.isPresent()) {
			Product product = selectedProduct.get();
		
			product.setName(name);
			product.setContent(content);
			product.setImage(image);
			product.setUpdated_at(LocalDateTime.now());
			
			updatedProduct = productRepository.save(product);
			
		} else {
			throw new Exception("product not found id : " + id);
		}
		return updatedProduct;
	}
	
	public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

	@Override
	public void deleteProduct(Long id) throws Exception {
		Optional<Product> selectedProduct = productRepository.findById(id);
		
		if(selectedProduct.isPresent()) {
			Product product = selectedProduct.get();
			
			productRepository.delete(product);
		} else {
			throw new Exception();
		}
	}

	@Override
	public List<Product> selectAllProduct() {
		return productRepository.findAll(); 
	}

}
