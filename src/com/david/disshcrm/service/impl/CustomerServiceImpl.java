package com.david.disshcrm.service.impl;

import java.util.List;

import com.david.disshcrm.common.dao.BaseDao;
import com.david.disshcrm.dao.CustomerDao;
import com.david.disshcrm.domain.Customer;
import com.david.disshcrm.domain.User;
import com.david.disshcrm.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务层
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
@Transactional//开启事务管理
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;
	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	/**
	 * 保存客户
	 */
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	public Customer getById(Long id) {
		return customerDao.getById(id);
	}

	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	public List<Customer> findAllByQBC() {
		return customerDao.findAllByQBC();
	}

	public Customer loadById(long id) {
		return customerDao.loadById(id);
	}

}
