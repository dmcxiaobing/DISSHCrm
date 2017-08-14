package com.david.disshcrm.domain;

import javax.persistence.*;

/**
 * 用户表，对用tb_user
 */
//@Table
//@Entity(name="tb_user")
public class User {

    private String username;//用户名
    private String password;//密码
    private String code;//激活码
    private String uid;//主键UUID
    private String email;//邮箱
//    @Column(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
//    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//    @Column(name="code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
//    @Id
//    @Column(name="uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
//    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
