package com.shopgenie.dao;

import com.shopgenie.entities.Seller;

public class SellerDao extends GenericDao<Seller, Long> {
	
	public SellerDao(Class<Seller> entity) {
		super(entity);
	}
	public SellerDao(){
		super(Seller.class);
	}
}
