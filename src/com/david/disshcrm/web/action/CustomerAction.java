package com.david.disshcrm.web.action;

import com.david.disshcrm.common.utils.CommonUtils;
import com.david.disshcrm.common.web.action.BaseAction;
import com.david.disshcrm.domain.Customer;
import com.david.disshcrm.domain.User;
import com.david.disshcrm.service.CustomerService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.util.List;


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
     * 添加用户，这里运用转发的功能，jsp不被直接访问。
     */
    public String prepareAdd() {
        return "prepareAdd";
    }
    /**
     * 客户列表，这里运用转发的功能，jsp不被直接访问。
     */
    public String prepareList() {
        //得到用户筛选输入的内容
        String inputCustNameValue = super.getHttpServletRequest().getParameter("cust_name");
        String inputPageSize = super.getHttpServletRequest().getParameter("pageSize");
        List<Customer> customers = customerService.findAllByInputValueLikePage(inputCustNameValue,inputPageSize);
        //将列表数据转发到list.jsp中
        this.request.put("list",customers);
        this.request.put("pageBean",customerService.getPageBean(inputPageSize));
//        super.getHttpServletRequest().setAttribute("pageBean",customerService.getPageBean(inputPageSize));
        return "prepareList";
    }

    /**
     * 添加用户，保存的方法
     */
    public String add() {
        try {
            customerService.save(customer);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * 编辑用户
     */
    public String edit() {
        try {
            List<Customer> customers = customerService.findCustomerById(customer.getCust_id());
            if (customers!=null && customers.size()>0){
                this.getRequest().put("customer",customers.get(0));
                return "edit";
            }else {
                return ERROR;
            }
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * 编辑用户 保存更改
     */
    public String saveUpdate() {
        try {
            customerService.saveUpdate(customer);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * 删除用户
     */
    public String delete() {
        try {
            customerService.delete(customer);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * 根据名称进行模糊查询
     */
    public String findByName(){
        List<Customer> customers = customerService.findByCustomerName(customer.getCust_name());
        this.request.put("list",customers);
        return "prepareList";
    }


}
