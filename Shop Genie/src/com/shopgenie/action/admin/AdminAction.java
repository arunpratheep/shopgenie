package com.shopgenie.action.admin;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.shopgenie.entities.Product;
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
    private List<Seller> unverifiedSellers;
    private List<Product> unverifiedProducts;

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
    public String verifySeller()
    {
	unverifiedSellers = adminLogic.verifyUser();
	for (Seller seller1 : unverifiedSellers)
	{
	    System.out.println(seller1.getSname());
	}
	return SUCCESS;
    }

    @Action(value = "/productVerify")
    public String verifyProduct()
    {
	System.out.println("Product Verify");
	unverifiedProducts = adminLogic.verifyProduct();
	for (Product product : unverifiedProducts)
	{
	    System.out.println(product.getProductName());
	}
	return SUCCESS;
    }

    @Action(value = "/verifySeller")
    public String sellerVerification()
    {
	String[] paramvalue = ServletActionContext.getRequest().getParameterValues("chkbox");
	for (int i = 0; i < paramvalue.length; i++)
	{
	    if (adminLogic.setVerifiedSeller(paramvalue[i]))
	    {
	    } else
	    {
		return ERROR;
	    }
	}
	return SUCCESS;
    }
    

    @Action(value = "/verifyProduct")
    public String productVerification()
    {
	String[] paramvalue = ServletActionContext.getRequest().getParameterValues("chkbox");
	for (int i = 0; i < paramvalue.length; i++)
	{
	    if (adminLogic.setVerifiedProduct(paramvalue[i]))
	    {
	    } else
	    {
		return ERROR;
	    }
	}
	return SUCCESS;
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

    public List<Seller> getUnverifiedSellers()
    {
	return unverifiedSellers;
    }

    public void setUnverifiedSellers(List<Seller> unverifiedSellers)
    {
	this.unverifiedSellers = unverifiedSellers;
    }

    public List<Product> getUnverifiedProducts()
    {
        return unverifiedProducts;
    }

    public void setUnverifiedProducts(List<Product> unverifiedProducts)
    {
        this.unverifiedProducts = unverifiedProducts;
    }
}
