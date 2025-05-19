package com.example.store.json;

import java.util.ArrayList;
import java.util.List;

import com.example.store.model.Products;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsJson {
    private long id;
	private String productName;
	private int price;
	private LocalDateTime createdAt;

    public static ProductsJson packJson(Products product) {
		ProductsJson productsJson = new ProductsJson();
        productsJson.setId(product.getId());
		productsJson.setProductName(product.getProductName());
		productsJson.setPrice(product.getPrice());
		productsJson.setCreatedAt(product.getCreatedAt());
		return productsJson;
	}
	
	public static List<ProductsJson> packJsons(List<Products> products) {
		List<ProductsJson> productsListJson = new ArrayList<ProductsJson>();
		for(Products product:products) {
			productsListJson.add(packJson(product));
		}
		return productsListJson;
	}
}
