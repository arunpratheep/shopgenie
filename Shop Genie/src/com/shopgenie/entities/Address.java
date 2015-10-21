package com.shopgenie.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	public Address(String email, String addressLine1, String addressLine2, String district, String state,
			String pincode) {
		super();
		this.email = email;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		District = district;
		State = state;
		this.pincode = pincode;
	}

	private String email;
	private String addressLine1;
	private String addressLine2;
	private String District;
	private String State;
	private String pincode;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
