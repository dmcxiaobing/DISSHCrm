package com.david.disshcrm.web.action;

import com.david.disshcrm.common.utils.CommonUtils;
import com.david.disshcrm.common.web.action.BaseAction;
import com.david.disshcrm.domain.Customer;
import com.david.disshcrm.domain.User;
import com.david.disshcrm.service.CustomerService;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 客户的控制层
 *
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class CustomerAction extends BaseAction implements ModelDriven<Customer> {
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





}
