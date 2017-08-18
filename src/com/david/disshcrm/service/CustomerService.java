package com.david.disshcrm.service;

import com.david.disshcrm.domain.Customer;
import com.david.disshcrm.domain.PageBean;

import java.util.List;



public interface CustomerService {
	 void save(Customer customer);

    void delete(Customer customer);

	List<Customer> findCustomerById(String cust_id);

    List<Customer> findAll();
    List<Customer> findAllByInputValueLikePage(String inputCustNameValue, String inputPageSize, String inputCurrentPage);

    void saveUpdate(Customer customer);

    List<Customer> findByCustomerName(String cust_name);

    PageBean getPageBean(String inputPageSize);

}
