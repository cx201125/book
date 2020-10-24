package com.chenxin.blog.service;

import com.chenxin.blog.entity.About;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutService implements  AboutServiceImpl{
    @Autowired
    private About about;
    @Override
    public About getAbout() {
        return about;
    }
}
