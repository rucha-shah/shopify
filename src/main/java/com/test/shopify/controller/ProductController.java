package com.test.shopify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.shopify.entity.AllProductClass;
import com.test.shopify.service.ProductService;
import com.test.shopify.utils.Utils;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/getAllProducts")
	public AllProductClass getAllProducts() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		HttpEntity httpEntity = new HttpEntity(Utils.setHeaders(header));
		String url = "https://jack-test-2.myshopify.com/admin/api/2020-10/products.json";

		ResponseEntity<AllProductClass> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
				AllProductClass.class, 1);
		AllProductClass products = response.getBody();
		return products;
	}

	@PostMapping("/addAllProducts")
	public AllProductClass addAllProducts() {
		AllProductClass allProducts = getAllProducts();
		return productService.saveProduct(allProducts);
	}

	@Scheduled(fixedRate = 50000)
	public void schedularMethod() {
		System.out.println(addAllProducts());
	}
}
