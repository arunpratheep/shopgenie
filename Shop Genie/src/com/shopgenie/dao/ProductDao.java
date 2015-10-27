package com.shopgenie.dao;

import java.util.List;

import org.hibernate.Query;

import com.shopgenie.entities.Product;

public class ProductDao extends GenericDao<Product, Long> {
	
	public ProductDao(Class<Product> entity) {
		super(entity);
	}

	public ProductDao() {
		super(Product.class);
	}
	
	public List<Product> getUnverified()
	{
		Query query =startSession().createQuery("From Product where verified=?");
		query.setParameter(0, false);
		List<Product> results = query.list();
		if(results.isEmpty())
			return null;
		return results;
	}
}
