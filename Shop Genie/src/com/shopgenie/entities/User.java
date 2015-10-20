package com.shopgenie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User {
	@Id
	@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize    = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
	private Long uid;
	private String uname;
	private String password;
	
	
	//private Address address;
	
	public User() {
		
	}
	public User(String uname,String password){
		this.password=password;
		this.uname=uname;
	}
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
