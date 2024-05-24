package com.ot.shop.product.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ot.shop.product.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByProductCode(String productCode);

}
