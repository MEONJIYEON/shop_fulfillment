package com.ot.shop.product.data.dao;


import java.util.List;

import com.ot.shop.product.data.entity.Product;

public interface ProductDAO {
	Product insertProduct(Product product);
	
	Product selectOneProduct(Long id);
	
	//상품명, 상품 내용, 상품 이미지, 상품 가격
	Product updateProduct(Long id, String name, String content, Integer stock, String image, Integer price) throws Exception;
	
	void deleteProduct(Long id) throws Exception;
	
	List<Product> selectAllProduct();
}
