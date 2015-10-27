package com.shopgenie.dao;

import java.util.List;

import org.hibernate.Query;

import com.shopgenie.entities.Seller;

public class SellerDao extends GenericDao<Seller, Long> {
	
	public SellerDao(Class<Seller> entity) {
		super(entity);
	}
	public SellerDao(){
		super(Seller.class);
	}
	public Seller getByName(String name)
	{
		Query query =startSession().createQuery("From Seller where sname=?");
		query.setParameter(0, name);
		List results = query.list();
		if(results.isEmpty())
			return null;
		return (Seller) results.get(0);
	}
	public List<Seller> getUnverified()
	{
		Query query =startSession().createQuery("From Seller where verified=?");
		query.setParameter(0, false);
		List<Seller> results = query.list();
		if(results.isEmpty())
			return null;
		return results;
	}
	
}
