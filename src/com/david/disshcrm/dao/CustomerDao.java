package com.david.disshcrm.dao;

import com.david.disshcrm.domain.Customer;

import java.util.List;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */

public interface CustomerDao {
	public void save(Customer customer);

	public void update(Customer customer);

	public Customer getById(String id);

	public List<Customer> findAll();

	public List<Customer> findAllByQBC();

	public Customer loadById(String id);

    void delete(Customer customer);
}
