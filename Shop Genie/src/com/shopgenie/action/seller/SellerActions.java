package com.shopgenie.action.seller;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shopgenie.dao.SellerDao;
import com.shopgenie.entities.Address;
import com.shopgenie.entities.Seller;

public class SellerActions extends ActionSupport {

	private Seller seller;
	private Address address;
	private static final long serialVersionUID = 8929826603745493864L;

	@Action(value = "/register", results = { @Result(name = "success", location = "/seller/login.jsp"),
			@Result(name = "EMAIL_FAIL", location = "/seller/register.jsp", params = { "email", "fail" }),
			@Result(name = "MOBILE_FAIL", location = "/seller/register.jsp", params = { "mobile", "fail" }),
			@Result(name = "UNAME_FAIL", location = "/seller/register.jsp", params = { "uname", "fail" }) })
	public String register() {

		seller.setAddress(address);
		SellerDao sellerDao = new SellerDao();
		if (sellerDao.getByEmail(address.getEmail()) != null) {
			return "EMAIL_FAIL";
		} else if (sellerDao.getByName(seller.getSname()) != null) {

			return "UNAME_FAIL";

		} else if (sellerDao.getByMobile(seller.getMobile()) != null) {
			return "MOBILE_FAIL";
		} else {
			sellerDao.save(seller);
			return SUCCESS;
		}
	}

	@Action(value = "/login", results = { @Result(name = "success", location = "/seller/home.jsp"),
			@Result(name = "failure", location = "/seller/login.jsp", params = { "uname", "fail" }) })
	public String login() {
		SellerDao sellerDao = new SellerDao();

		if (sellerDao.getByName(seller.getSname()) == null) {

			return "failure";

		} else {
			Seller dbSeller = sellerDao.getByName(seller.getSname());
			if (dbSeller.getPassword().equals(seller.getPassword())) {
				Map session = ActionContext.getContext().getSession();
				session.put("login", "true");
				session.put("seller", seller.getSname());
				return "success";
			} else
				return "failure";
		}

	}

	@Action(value = "/logout", results = { @Result(name = "logout", location = "/seller/login.jsp") })
	public String logout() {
		Map session = ActionContext.getContext().getSession();
		session.clear();
		return "logout";
	}

	@Action(value = "/profile", results = { @Result(name = "profile", location = "/seller/profile.jsp") })
	public String profile() {
		SellerDao sellerDao = new SellerDao();
		Map session = ActionContext.getContext().getSession();
		seller = sellerDao.getByName(session.get("seller").toString());
		address = seller.getAddress();
		return "profile";
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
