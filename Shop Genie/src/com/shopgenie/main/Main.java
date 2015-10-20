package com.shopgenie.main;

import com.shopgenie.dao.AdminDao;
import com.shopgenie.dao.CategoryDao;
import com.shopgenie.dao.ProductDao;
import com.shopgenie.dao.SessionFactoryMySQL;
import com.shopgenie.entities.Admin;
import com.shopgenie.entities.Product;

public class Main {

	public static void main(String[] args) {
		/*CategoryDao categoryDao=new CategoryDao();
		
		
		ProductDao productDao=new ProductDao();
		Product levisJeans=new Product("s4roduct id");
		levisJeans.setCategory(categoryDao.get((long) 1));
		productDao.save(levisJeans);*/
		Admin admin;
		AdminDao adminDao=new AdminDao();
		admin=adminDao.getByName("himaprasoo");
		System.out.println(admin.getPassword());
		SessionFactoryMySQL.close();
		
	}

}
