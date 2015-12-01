package com.dev.backend.services;

import java.util.List;

import javax.ws.rs.core.Response;

import com.dev.backend.to.Customer;

public interface Services {
	
	public static final int TYPE_PRODUCT = 1;
	public static final int TYPE_CUSTOMER = 2;
	public static final int TYPE_SALESORDER = 3;
	
	public abstract Response save(Customer customer);
	
	public abstract Object readRecordByCode(String code, int objectType);
	
	public abstract boolean deleteRecordByCode(String code, int objectType);
	
	public abstract List<Object> listCurrentRecords(int objectType);
	
	public abstract List<Object[]> listCurrentRecordRefernces(int objectType);
	
	public abstract double getProductPrice(String productCode);
}