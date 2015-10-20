package com.shopgenie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Seller {

	@Id
	@SequenceGenerator(name = "seq_seller", sequenceName = "seq_seller", allocationSize    = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_seller")
	private Long sid;
	private String sname;
	private String password;
	
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
}
