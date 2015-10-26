package com.shopgenie.action.admin;

import java.util.List;

import com.shopgenie.dao.AdminDao;
import com.shopgenie.dao.SellerDao;
import com.shopgenie.entities.Admin;
import com.shopgenie.entities.Seller;

public class AdminLogic
{

    public boolean loginValidate(String name, String password)
    {
	AdminDao adminDao = new AdminDao();
	Admin admin = new Admin();
	if (adminDao.getByName(name) == null)
	{
	    return false;
	} else
	{
	    admin = adminDao.getByName(name);
	    if (admin.getPassword().equals(password))
	    {
		return true;
	    }
	    return false;
	}
    }
    
    public List<Seller> verifyUser()
    {
	SellerDao sellerDao=new SellerDao();
	List<Seller> unverifiedSellers;
	unverifiedSellers=sellerDao.getUnverified();
	return unverifiedSellers;
    }
}
