package com.david.disshcrm.service.impl;

import com.david.disshcrm.common.dao.BaseDao;
import com.david.disshcrm.domain.User;
import com.david.disshcrm.service.UserService;
import org.hibernate.Query;

import java.util.List;

/**
 * 管理员登陆的
 */
public class UserServiceImpl implements UserService {
    private BaseDao baseDao;

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }
    @Override
    public List<User> login(User formUser) {
        Object[] params = {formUser.getUsername(),formUser.getPassword()};
        return baseDao.find("from User where username = ? and password = ?",User.class,params);
    }

    @Override
    public User regist(User formUser) {
        return null;
    }

    @Override
    public User active(User formUser) {
        return null;
    }
}
