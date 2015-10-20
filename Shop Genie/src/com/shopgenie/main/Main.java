package com.shopgenie.main;

import com.shopgenie.dao.CategoryDao;
import com.shopgenie.dao.SessionFactoryMySQL;
import com.shopgenie.entities.Category;

public class Main {

	public static void main(String[] args) {
	
		Category grandson=new Category();
		grandson.setCategoryName("Mobiles ");
		
		Category granddaughter=new Category();
		granddaughter.setCategoryName("Accessories");
		
		Category son=new Category();
		son.setCategoryName("Mobiles and Accessories");
		son.addCategory(granddaughter);
		son.addCategory(grandson);
		
		Category daughter=new Category();
		daughter.setCategoryName("Laptops");
		
		Category category=new Category();
		CategoryDao categoryDao=new CategoryDao();
		category.setCategoryName("Electronic");
		category.addCategory(son);
		category.addCategory(daughter);
		categoryDao.save(category);
		SessionFactoryMySQL.close();
	}

}
