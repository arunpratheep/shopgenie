package com.shopgenie.dao;

import com.shopgenie.entities.Admin;

public class AdminDao extends GenericDao<Admin, String> {
	
	public AdminDao(Class<Admin> entity) {
		super(entity);
	}
	public AdminDao()
	{
		super(Admin.class);
	}
}
