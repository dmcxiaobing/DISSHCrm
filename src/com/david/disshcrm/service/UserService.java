package com.david.disshcrm.service;

import com.david.disshcrm.domain.User;

import java.util.List;

public interface UserService {
    List<User> login(User formUser);
    void regist(User formUser);
    User active(User formUser);

    List findUserByUserName(String username);
}
