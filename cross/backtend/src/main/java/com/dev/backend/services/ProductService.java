package com.dev.backend.services;

import java.util.List;

import javax.ws.rs.core.Response;

import com.dev.backend.to.Customer;
import com.dev.backend.to.Product;

public interface ProductService {
	public static final int TYPE_PRODUCT = 1;
	
	public abstract Response save(Product product);
	
	public abstract Object readRecordByCode(String code, int objectType);
	
	public abstract boolean deleteRecordByCode(String code, int objectType);
	
	public abstract List<Object> listCurrentRecords(int objectType);
	
	public abstract List<Object[]> listCurrentRecordRefernces(int objectType);
	
	public abstract double getProductPrice(String productCode);
}
