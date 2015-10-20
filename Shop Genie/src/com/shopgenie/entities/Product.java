package com.shopgenie.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Product {
	
	@Id
	@SequenceGenerator(name = "seq_product", sequenceName = "seq_product", allocationSize    = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
	private Long productId;
	@Column(nullable=false,unique=true)
	private String productName;
	private Boolean verified=false;
	
	public Product() {
		super();
	}
	@ManyToOne
	@JoinColumn(name="categoryId",nullable=false)
	Category category;
	
	public Product(String productName) {
		super();
		this.productName = productName;
	}
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
	
	public Boolean getVerified()
	{
	    return verified;
	}
	public void setVerified(Boolean verified)
	{
	    this.verified = verified;
	}

}
