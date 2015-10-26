package com.shopgenie.business;

import com.shopgenie.dao.SellerDao;

public class SellerFunction {

	static SellerDao sellerDao=new SellerDao();;
	public SellerFunction() {
		
	}
	
	public static boolean checkEmailExists(String email){
		if(sellerDao.getByName(email)!=null)
			return true;
		return false;
	}
	public static boolean checkUnameExists(String Uname){
		if(sellerDao.getByName(Uname)!=null)
			return true;
		return false;
	}
	public static boolean checkMobileExists(String mobile){
		if(sellerDao.getByName(mobile)!=null)
			return true;
		return false;
	}
}
