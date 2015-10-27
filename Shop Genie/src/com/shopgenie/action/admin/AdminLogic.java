package com.shopgenie.action.admin;

import java.util.List;

import org.hibernate.Query;

import com.shopgenie.dao.AdminDao;
import com.shopgenie.dao.ProductDao;
import com.shopgenie.dao.SellerDao;
import com.shopgenie.entities.Admin;
import com.shopgenie.entities.Product;
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
	System.out.println("AdminLogic verifyuser()");
	SellerDao sellerDao = new SellerDao();
	List<Seller> unverifiedSellers;
	unverifiedSellers = sellerDao.getUnverified();
	return unverifiedSellers;
    }

    public boolean setVerifiedSeller(String verify)
    {
	SellerDao sellerDao = new SellerDao();
	Long id = Long.parseLong(verify);
	Query query = sellerDao.startSession().createQuery("update Seller set verified= true where sid=?");
	query.setParameter(0, id);
	if (query.executeUpdate() >= 0)
	{
	    System.out.println("Succcess");
	    sellerDao.close();
	    return true;

	}
	System.out.println("Error");
	sellerDao.close();
	return false;
    }

    public List<Product> verifyProduct()
    {
	System.out.println("AdminLogic verifyproduct()");
	ProductDao productDao = new ProductDao();
	List<Product> unverifiedProductss;
	unverifiedProductss = productDao.getUnverified();
	return unverifiedProductss;
    }

    public boolean setVerifiedProduct(String verify)
    {
	ProductDao productDao = new ProductDao();
	Long id = Long.parseLong(verify);
	Query query = productDao.startSession().createQuery("update Product set verified= true where productId=?");
	query.setParameter(0, id);
	if (query.executeUpdate() >= 0)
	{
	    System.out.println("Succcess");
	    productDao.close();
	    return true;

	}
	System.out.println("Error");
	productDao.close();
	return false;
    }
}
