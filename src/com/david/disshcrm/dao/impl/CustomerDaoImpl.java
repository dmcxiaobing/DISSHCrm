package com.david.disshcrm.dao.impl;

import java.util.List;

import com.david.disshcrm.dao.CustomerDao;
import com.david.disshcrm.domain.Customer;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
/**
 * 持久层
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	/**
	 * 保存客户
	 */
	public void save(Customer customer) {
		//把数据保存到数据库中
		this.getHibernateTemplate().save(customer);
	}
	/**
	 * 修改客户
	 */
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}
	/**
	 * 通过主键查询
	 */
	public Customer getById(String id) {
		return this.getHibernateTemplate().get(Customer.class, id);
	}
	/**
	 * 查询所有
	 */
	public List<Customer> findAll() {
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}
	/**
	 * 查询所有的数据，使用QBC的查询
	 */
	public List<Customer> findAllByQBC() {

		return null;
	}
	/**
	 * 演示延迟加载
	 */
	public Customer loadById(String id) {
		return this.getHibernateTemplate().load(Customer.class, id);
	}

	/**
	 * 通过UUID删除用户
	 */
	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

}
