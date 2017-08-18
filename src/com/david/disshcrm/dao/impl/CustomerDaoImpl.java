package com.david.disshcrm.dao.impl;

import java.util.List;

import com.david.disshcrm.dao.CustomerDao;
import com.david.disshcrm.domain.Customer;
import com.david.disshcrm.utils.LogUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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


	@Override
	public List<Customer> findAllByCustomerName(String cust_name) {
		return null;
	}

	/**
	 * 查询出总记录数
	 */
	@Override
	public Integer findTotalSize() {
		Session session = currentSession();
		Query query = session.createQuery("select count(c.cust_id) from Customer c");
		List<Number> list = query.list();
		int count = list.get(0).intValue();
		return count;
	}

	/**
	 * 这里首先看每页记录数是否为空，然后再去得到总页数
	 */
	public Integer findTotalPage(String pageSize) {
		//如果每页记录数为空，则设置为0
		int p = 1;
		if (StringUtils.isEmpty(pageSize)||pageSize == null||pageSize.trim().equals("")) {
			LogUtils.e("pageSize: is empty");
			p = 10;
		}
		return getTotalPage(findTotalSize(), p);
	}

	/**
	 * 根据用户输入的内容模查询
	 */
	@Override
	public List<Customer> findAllByInputValueLikePage(String inputCustNameValue, String inputPageSize) {

		Criteria criteria = currentSession().createCriteria(Customer.class);
		// 如果筛选的条件不为空
		if (inputCustNameValue != null && !(inputCustNameValue.trim().isEmpty())) {
			// 添加查询条件
			criteria.add(Restrictions.like("cust_name", "%" + inputCustNameValue + "%"));
		}
		//如果pageSize 为null,则默认为10
		int pagesize = 0;
		if (inputPageSize == null||inputPageSize.trim().equals("")) {
			pagesize = 10;
		}else {
			pagesize = Integer.parseInt(inputPageSize);
		}
		// 查询得到客户集合
		List<Customer> lists = criteria.list();
		return lists;
	}

	/**
	 * 返回总页数
	 */
	public Integer getTotalPage(Integer totalSize,Integer pageSize) {
		// 总记录数 除以每页记录数
		int tp = totalSize / pageSize;
		return totalSize % pageSize == 0 ? tp : tp + 1;
	}


}
