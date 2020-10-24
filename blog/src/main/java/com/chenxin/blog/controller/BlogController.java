package com.chenxin.blog.controller;

import com.chenxin.blog.entity.Blog;
import com.chenxin.blog.service.BlogService;
import com.chenxin.blog.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogController {
    @Autowired
    BlogServiceImpl blogService;
    @GetMapping("/blog/{id}")
    public String BlogPage(@PathVariable Long id,Model model){
        Blog blog=blogService.findBlogById(id);

        model.addAttribute("blog",blog);
        return "blog";
    }
}
