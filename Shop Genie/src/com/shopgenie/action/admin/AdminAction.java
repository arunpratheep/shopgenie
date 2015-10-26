package com.shopgenie.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.shopgenie.entities.Seller;

@Results({ @Result(name = "success", location = "/admin/adminhome.jsp"),
	@Result(name = "login", location = "/admin/login.jsp") })
public class AdminAction extends ActionSupport
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    AdminLogic adminLogic = new AdminLogic();

    @Action(value = "/Adminlogin")
    public String execute()
    {
	if (adminLogic.loginValidate(name, password))
	{
	    return SUCCESS;
	}
	return LOGIN;
    }

    @Action(value = "/sellerVerify")
    public void verifySeller()
    {
	List<Seller> unverifiedSellers=adminLogic.verifyUser();
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
