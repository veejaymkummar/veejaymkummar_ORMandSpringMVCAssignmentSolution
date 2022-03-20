package com.rnd.crm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rnd.crm.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public CustomerDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException exception) {
			session = sessionFactory.openSession();
		}
	}

	@Override
	public boolean SaveCustomer(Customer C) {
		Transaction Txn = session.beginTransaction();
		session.save(C);
		Txn.commit();
		return true;
	}

	@Override
	public boolean UpdateCustomer(Customer C) {
		Transaction Txn = session.beginTransaction();
		session.merge(C);
		
		Txn.commit();
		return true;
	}

	@Override
	public boolean DeleteCustomer(int id) {
		Transaction Txn = session.beginTransaction();
		Customer C = session.get(Customer.class, id);
		session.delete(C);
		Txn.commit();
		return true;
	}

	@Override
	public Customer getCustomer(int id) {
		return session.get(Customer.class, id);
	}

	@Override
	public List<Customer> getAllCustomer() {

		return session.createQuery("from Customer", Customer.class).getResultList();
	}

}
