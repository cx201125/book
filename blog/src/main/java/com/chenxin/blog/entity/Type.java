package com.chenxin.blog.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Type implements Serializable {
    private Long id;//id

    private String name;//名称

    private Integer countBlog;

    private ArrayList<Blog> blogs=new ArrayList<>();//博客
    private static final long serialVersionUID = 1L;

    public Integer getCountBlog() {
        return countBlog;
    }

    public void setCountBlog(Integer countBlog) {
        this.countBlog = countBlog;
    }

    public ArrayList<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(ArrayList<Blog> blogs) {
        this.blogs = blogs;
    }

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
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}