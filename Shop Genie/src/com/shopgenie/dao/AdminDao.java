package com.shopgenie.dao;

import java.util.List;

import org.hibernate.Query;

import com.shopgenie.entities.Admin;

public class AdminDao extends GenericDao<Admin, String> {
	
	public AdminDao(Class<Admin> entity) {
		super(entity);
	}
	public AdminDao()
	{
		super(Admin.class);
	}
	public Admin getByName(String name)
	{
		Query query =startSession().createQuery("From Admin where name=?");
		query.setParameter(0, name);
		List results = query.list();
		if(results.isEmpty())
			return null;
		return (Admin) results.get(0);
	}
}
