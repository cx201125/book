package com.chenxin.blog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tag implements Serializable {
    private Long id;//id

    private String name;//名称

    private Integer countBlog;
    private List<Blog> blogs=new ArrayList<>();//博客

    public Integer getCountBlog() {
        return countBlog;
    }

    public void setCountBlog(Integer countBlog) {
        this.countBlog = countBlog;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'';

    }
}