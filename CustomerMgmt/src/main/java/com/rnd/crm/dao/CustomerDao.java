package com.rnd.crm.dao;

import java.util.List;

import com.rnd.crm.entity.Customer;

public interface CustomerDao {

	public boolean SaveCustomer(Customer C);
	public boolean UpdateCustomer(Customer C);
	public boolean DeleteCustomer(int id);
	public Customer getCustomer(int id);
	public List<Customer> getAllCustomer();
}
