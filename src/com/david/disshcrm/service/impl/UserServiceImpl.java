package com.david.disshcrm.service.impl;

import com.david.disshcrm.common.dao.BaseDao;
import com.david.disshcrm.common.utils.CommonUtils;
import com.david.disshcrm.domain.User;
import com.david.disshcrm.service.UserService;
import com.david.disshcrm.utils.LogUtils;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 管理员 用户的业务
 */
@Transactional//开启事务管理
public class UserServiceImpl implements UserService {
    private BaseDao baseDao;

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    /**
     * 登录，使用用户名和密码进行匹配
     */
    @Override
    public List<User> login(User formUser) {
        Object[] params = {formUser.getUsername(), formUser.getPassword()};
        return baseDao.find("from User where username = ? and password = ?", User.class, params);
    }

    /**
     * 注册用户到数据库
     */
    @Override
    public void regist(User formUser) {
        formUser.setDel(0);//默认不删除，账户可用
        formUser.setUid(CommonUtils.getUUIDRandomNum());
        baseDao.save(formUser);
    }

    /**
     * 激活账户
     */
    @Override
    public User active(User formUser) {
        return null;
    }

    /**
     * 根据 用户名查找用户
     */
    @Override
    public List<User> findUserByUserName(String username) {
        Object[] params = {username};
        return baseDao.find("from User where username = ?", User.class, params);
    }
}
