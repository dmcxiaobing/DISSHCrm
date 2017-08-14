package com.david.disshcrm.web.action;

import com.david.disshcrm.domain.Customer;
import com.david.disshcrm.service.CustomerService;
import com.david.disshcrm.utils.LogUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 客户的控制层
 *
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    //得到service
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    //将表单数据封装到对象中
    private Customer customer = new Customer();

    public Customer getModel() {
        return customer;
    }


    /**
     * 添加用户，保存的方法
     */
    public String add() {
        customerService.save(customer);
        return NONE;
    }


    /**
     * 登陆的方法
     */
    public String login() {
        LogUtils.e("login");
        return LOGIN;
    }


}
