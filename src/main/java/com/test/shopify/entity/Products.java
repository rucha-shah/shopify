package com.test.shopify.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Products {

	@Id
	public Long id;
	public String title;
	public String vendor;
	public String product_type;
	public List<Variant> variants;

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", vendor=" + vendor + ", productType=" + product_type
				+ ", variants=" + variants + "]";
	}

}
