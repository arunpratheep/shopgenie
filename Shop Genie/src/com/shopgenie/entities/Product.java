package com.shopgenie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Product {
	
	@Id
	@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize    = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	Long productId;
	String productName;
	Boolean verified;
	
	public Boolean getVerified()
	{
	    return verified;
	}
	public void setVerified(Boolean verified)
	{
	    this.verified = verified;
	}
	@ManyToOne
	Category category;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	

}
