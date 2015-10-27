package com.shopgenie.action.seller;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class ProductManagement extends ActionSupport {

	/**
	 * 
	 */
	private List<String> products=new ArrayList<String>();
	private static final long serialVersionUID = -4679106702054654512L;
	private String selectedProduct;
	public ProductManagement() {
		// TODO Auto-generated constructor stub
	}



	@Action(value = "/autoCompleteProduct", results = { @Result(name = "none", location = "/seller/sell.jsp") })
	public String autoComplete() {
		products.add("one");
		products.add("two");
		products.add("three");
		for(int i=0;i<17;i++){
			products.add("product "+i);
		}
		return "none";
	}
	@Action(value = "/selectProduct", results = { @Result(name = "none", location = "/seller/sell.jsp") })
	public String selectProduct() {
		
		return "none";
	}
	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> products) {
		this.products = products;
	}



	public String getSelectedProduct() {
		return selectedProduct;
	}



	public void setSelectedProduct(String selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
}
