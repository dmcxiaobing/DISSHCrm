package com.david.disshcrm.service;

import com.david.disshcrm.domain.Customer;

import java.util.List;



public interface CustomerService {
	 void save(Customer customer);

    void delete(Customer customer);

	List<Customer> findCustomerById(String cust_id);

    List<Customer> findAll();

    void saveUpdate(Customer customer);
}
