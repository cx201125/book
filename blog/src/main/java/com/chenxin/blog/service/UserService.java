package com.chenxin.blog.service;

import com.chenxin.blog.entity.User;
import com.chenxin.blog.entity.UserExample;
import com.chenxin.blog.mapper.UserMapper;
import com.chenxin.blog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "/user")
public class UserService implements UserServiceImpl{
    @Autowired
    UserMapper userMapper;

    UserExample userExample=new UserExample();
    @Override
    //@Cacheable(key = "#user.username")
    public User LoginVerify(User user) {
        String md5 = MD5Util.MD5Encode(user.getPassword(), "utf8");
        System.out.println(md5);
        userExample.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(md5);
        List<User> users = userMapper.selectByExample(userExample);
        userExample.clear();
        if(users.size()>=1){
            return users.get(0);
        }else{
            return null;
        }
    }
}
