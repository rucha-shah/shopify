package com.test.shopify.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.test.shopify.entity.Products;

@Repository
public interface ProductRepository extends MongoRepository<Products, Long>{

}
