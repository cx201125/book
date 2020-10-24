package com.chenxin.blog.service;

import com.chenxin.blog.entity.User;

import java.util.List;

public interface UserServiceImpl {
    /**
     * 获取用户，用于用户登录校验
     * @param user
     * @return
     */
    public User LoginVerify(User user);
}
