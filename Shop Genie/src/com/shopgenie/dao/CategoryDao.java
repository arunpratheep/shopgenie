package com.shopgenie.dao;

import com.shopgenie.entities.Category;

public class CategoryDao extends GenericDao<Category, Long> {

	public CategoryDao(Class<Category> entity) {
		super(entity);
	}

	public CategoryDao(){
		
		super(Category.class);
	}
}
