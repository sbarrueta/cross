package com.dev.backend.to;

import java.io.Serializable;

public class Product implements Serializable{
	
	private String code;
	private String description;
	private float price;
	private int quantity;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String code, String description, float price, int quantity) {
		super();
		this.code = code;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
