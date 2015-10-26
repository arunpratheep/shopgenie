package com.shopgenie.action.seller;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.shopgenie.dao.SellerDao;
import com.shopgenie.entities.Seller;

@Results({@Result(name="success",location="/seller/SellerHome.jsp"),@Result(name="login",location="/seller/login.jsp")})
public class SellerAction extends ActionSupport
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    Seller seller=new Seller();
    @Action(value="/Sellerlogin")
    public String execute()
    {
	SellerDao sellerDao=new SellerDao();
	if(sellerDao.getByName(name)==null)
	{
	    return LOGIN;
	}
	else
	{
	    seller=sellerDao.getByName(name);
	    if(seller.getPassword().equals(password)){
		return SUCCESS;
	    }
	    return LOGIN;
	}
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
}
