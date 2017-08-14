package com.david.disshcrm.service;

import com.david.disshcrm.domain.User;

import java.util.List;

public interface UserService {
    List<User> login(User formUser);
    User regist(User formUser);
    User active(User formUser);
}
