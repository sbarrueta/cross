package com.dev.backend.services.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.backend.services.Services;
import com.dev.backend.to.Customer;

@Repository
public class Dao{
	
	public static final int TYPE_PRODUCT = 1;
	public static final int TYPE_CUSTOMER = 2;
	public static final int TYPE_SALESORDER = 3;

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Customer save(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
		return customer;
	}

	@Transactional
	public Object readRecordByCode(String code, int objectType) {
		switch (objectType) {
		case TYPE_PRODUCT:
			return null;
		case TYPE_CUSTOMER:
			return sessionFactory.getCurrentSession().get(Customer.class, code);
		case TYPE_SALESORDER:
			return null;
		}

		return null;
	}

	@Transactional
	public boolean deleteRecordByCode(String code, int objectType) {
		switch (objectType) {
		case TYPE_PRODUCT:
			return false;
		case TYPE_CUSTOMER:
			Customer c = new Customer();
			c.setCode(code);

			sessionFactory.getCurrentSession().delete(c);

			return true;
		case TYPE_SALESORDER:
			return false;
		}

		return false;
	}

	@Transactional
	public List<Object> listCurrentRecords(int objectType) {
		switch (objectType) {
		case TYPE_PRODUCT:
			return null;
		case TYPE_CUSTOMER:
			String hql = "SELECT c.code, c.name, c.phone1, c.currentCredit FROM Customer c";
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		case TYPE_SALESORDER:
			return null;
		}

		return null;
	}

	public List<Object[]> listCurrentRecordRefernces(int objectType) {
		String hql;
		switch (objectType) {
		case TYPE_PRODUCT:
			return null;
		case TYPE_CUSTOMER:
			hql = "SELECT c.code, c.name FROM Customer c";
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		case TYPE_SALESORDER:
			return null;
		}

		return null;
	}

	public double getProductPrice(String productCode) {
		String hql = "SELECT p.unitPrice FROM Product p WHERE code = :code";
		return (Double) sessionFactory.getCurrentSession().createQuery(hql).setParameter("code", productCode)
				.uniqueResult();
	}
}