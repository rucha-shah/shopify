package com.test.shopify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShopifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopifyApplication.class, args);
	}

}
