package com.shopgenie.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Seller {

	@Id
	@SequenceGenerator(name = "seq_seller", sequenceName = "seq_seller", allocationSize    = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_seller")
	private Long sid;
	@Column(nullable=false,unique=true)
	private String sname;
	@Column(nullable=false)
	private String password;
	private String mobile;
	@Embedded
	private Address address;
	private Boolean verified=false;
	
	@OneToMany(mappedBy="seller",cascade=CascadeType.ALL)
	private Collection<Stock> stock = new ArrayList<Stock>();
	
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Stock> getStock() {
		return stock;
	}
	public void setStock(Collection<Stock> stock) {
		this.stock = stock;
	}
	public Boolean getVerified() {
		return verified;
	}
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
