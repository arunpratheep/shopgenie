package com.shopgenie.functions;

import java.util.List;

import com.shopgenie.dao.SellerDao;
import com.shopgenie.entities.Seller;

public class AdminFunction
{
    public void verifyUser()
    {
	SellerDao sellerDao=new SellerDao();
	List<Seller> unverifiedSellers;
	unverifiedSellers=sellerDao.getUnverified();
    }
}
