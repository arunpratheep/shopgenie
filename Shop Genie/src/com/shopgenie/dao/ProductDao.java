package com.shopgenie.dao;

import com.shopgenie.entities.Product;

public class ProductDao extends GenericDao<Product, Long> {
	
	public ProductDao(Class<Product> entity) {
		super(entity);
	}

	public ProductDao() {
		super(Product.class);
	}
}
