package com.dev.backend.services.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.backend.to.Customer;
import com.dev.backend.to.Product;

@Repository
public class ProductDao {
	public static final int TYPE_PRODUCT = 1;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Product save(Product product) {
		sessionFactory.getCurrentSession().save(product);
		return product;
	}

	@Transactional
	public Object readRecordByCode(String code, int objectType) {
		switch (objectType) {
		case TYPE_PRODUCT:
			return sessionFactory.getCurrentSession().get(Product.class, code);
		}

		return null;
	}

	@Transactional
	public boolean deleteRecordByCode(String code, int objectType) {
		switch (objectType) {
		case TYPE_PRODUCT:
			
			Product p = new Product();
			p.setCode(code);

			sessionFactory.getCurrentSession().delete(p);

			return true;
		
		}

		return false;
	}

	@Transactional
	public List<Object> listCurrentRecords(int objectType) {
		switch (objectType) {
		case TYPE_PRODUCT:
			
			String hql = "SELECT p.code, p.description, p.price, p.quantity FROM Product p";
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		
		}

		return null;
	}

	public List<Object[]> listCurrentRecordRefernces(int objectType) {
		String hql;
		switch (objectType) {
		case TYPE_PRODUCT:
			
			hql = "SELECT p.code, p.description FROM Product p";
			return sessionFactory.getCurrentSession().createQuery(hql).list();
	
		}

		return null;
	}

	public double getProductPrice(String productCode) {
		String hql = "SELECT p.price FROM Product p WHERE code = :code";
		return (Double) sessionFactory.getCurrentSession().createQuery(hql).setParameter("code", productCode)
				.uniqueResult();
	}
}
