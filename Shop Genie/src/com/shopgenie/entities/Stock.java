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
public class Stock {
	@Id
	@SequenceGenerator(name = "seq_stockid", sequenceName = "seq_stockid", allocationSize    = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_stockid")
	Integer stockid;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sid")
	private Seller seller;
	@JoinColumn(name="productId")
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;
	@Column(nullable=false)
	double price;
	@Column(nullable=false)
	double stock;
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}
	
}
