package com.david.disshcrm.web.action;

import com.david.disshcrm.common.utils.CommonUtils;
import com.david.disshcrm.common.web.action.BaseAction;
import com.david.disshcrm.domain.User;
import com.david.disshcrm.service.UserService;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 管理员登陆的action
 */
public class UserAction extends BaseAction implements ModelDriven<User> {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private User userform = new User();
    @Override
    public User getModel() {
        return userform;
    }


    /**
     * 登陆的方法
     */
    public String login() {
        if (userform != null && userform.getUsername()!=null && userform.getPassword()!=null
                &&!userform.getUsername().trim().isEmpty()
                &&!userform.getPassword().trim().isEmpty()) {
            //调用业务层，登陆。
            List<User> users = userService.login(userform);
            if (users == null || users.size()<1) {
                //如果user等于null，则说明用户名或者密码错误，或者不存在此用户
                return LOGIN;
            }else {
                //如果存在，则将用户信息保存到session域中 值栈中
                this.getSession().put("session_user", users.get(0));
                return "index";
            }
        }else {
            return LOGIN;
        }
    }


}
