package com.test.shopify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.shopify.entity.AllProductClass;
import com.test.shopify.entity.Products;
import com.test.shopify.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public AllProductClass saveProduct(AllProductClass allProductClass) {
		for (Products products : allProductClass.products) {
			productRepository.save(products);
		}
		return allProductClass;
	}
}
