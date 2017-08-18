package com.david.disshcrm.service.impl;

import java.util.List;

import com.david.disshcrm.common.dao.BaseDao;
import com.david.disshcrm.dao.CustomerDao;
import com.david.disshcrm.domain.Customer;
import com.david.disshcrm.domain.PageBean;
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


	/**
	 * 根据UUID删除客户
	 */
	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	/**
	 * 根据ID查找客户
	 * @param cust_id
	 */
	@Override
	public List<Customer> findCustomerById(String cust_id) {
		Object[] params = {cust_id};
		return baseDao.find("from Customer where cust_id = ?",Customer.class,params);
	}

	/**
	 * 查询所有客户
	 */
	@Override
	public List<Customer> findAll() {
//		return baseDao.find("from Customer",Customer.class,null);
		return customerDao.findAll();
	}

	/**
	 * 分页查询并筛选内容。查询所有的客户
	 */
	@Override
	public List<Customer> findAllByInputValueLikePage(String inputCustNameValue, String inputPageSize, String inputCurrentPage) {

		return customerDao.findAllByInputValueLikePage(inputCustNameValue,inputPageSize,inputCurrentPage);
	}

	@Override
	public void saveUpdate(Customer customer) {
		baseDao.saveOrUpdate(customer);
	}

	/**
	 * 根据客户名称模糊查询
	 */
	@Override
	public List<Customer> findByCustomerName(String cust_name) {

		return customerDao.findAllByCustomerName(cust_name);
	}

	/**
	 * 得到pagebean的一些值。比如总页码，总记录数
	 * @param inputPageSize
	 */
	@Override
	public PageBean getPageBean(String inputPageSize) {
		PageBean pageBean = new PageBean();
		//设置总记录数
		pageBean.setTotalSize(customerDao.findTotalSize());
		pageBean.setTotalPage(customerDao.findTotalPage(inputPageSize));
		return pageBean;
	}

}
