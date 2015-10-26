package com.shopgenie.action.seller;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shopgenie.entities.Address;
import com.shopgenie.entities.Seller;

@Namespace("/seller")
@Result(name="success",location="/login.jsp")
public class SellerActions extends ActionSupport
{

	private Seller seller;
	private Address address;
	private static final long serialVersionUID = 8929826603745493864L;
	@Action(value="/register")
	public String register(){
		seller.setAddress(address);
		System.out.println(seller.getSname());
		System.out.println(seller.getMobile());
		System.out.println(seller.getPassword());
		System.out.println(address.getEmail());
		return SUCCESS;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}
