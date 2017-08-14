package com.david.disshcrm.service;

import com.david.disshcrm.domain.Customer;

import java.util.List;



public interface CustomerService {
public void save(Customer customer);
	
	public void update(Customer customer);
	
	public Customer getById(Long id);
	
	public List<Customer> findAll();
	
	public List<Customer> findAllByQBC();

	public Customer loadById(long id);
	
}
