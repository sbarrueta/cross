package com.dev.backend.to;

import java.io.Serializable;

public class Customer implements Serializable {

	private String code;
	private String name;
	private String address;
	private String phone1;
	private String phone2;
	private float creditLimit;
	private float currentCredit;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String code, String name, String address, String phone1, String phone2, float creditLimit,
			float currentCredit) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.creditLimit = creditLimit;
		this.currentCredit = currentCredit;
	}

	@Override
	public String toString() {
		return "Customer [code=" + code + ", name=" + name + ", address=" + address + ", phone1=" + phone1 + ", phone2="
				+ phone2 + ", creditLimit=" + creditLimit + ", currentCredit=" + currentCredit + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public float getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(float creditLimit) {
		this.creditLimit = creditLimit;
	}

	public float getCurrentCredit() {
		return currentCredit;
	}

	public void setCurrentCredit(float currentCredit) {
		this.currentCredit = currentCredit;
	}
}