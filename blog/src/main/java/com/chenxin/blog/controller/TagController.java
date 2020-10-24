package com.chenxin.blog.controller;

import com.chenxin.blog.entity.Blog;
import com.chenxin.blog.entity.Tag;

import com.chenxin.blog.service.BlogServiceImpl;
import com.chenxin.blog.service.TagServiceImpl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class TagController {
    @Autowired
    TagServiceImpl tagService;
    @Autowired
    BlogServiceImpl blogService;
    @GetMapping("/tags")
    public String typelist(Integer pagenum, Model model,Long id){

        List<Tag> tags=tagService.findAll();

        model.addAttribute("tags",tags);

        int i = 1;
        if (pagenum != null) {
            i = pagenum;

        }
        if(id==null) {
            id=tags.get(0).getId();
        }
        model.addAttribute("tagId",id);
                Page<Blog> blogs = blogService.findByTagIdAndPage(id, i);
                model.addAttribute("page", blogs);
        return "tags";
    }
    @PostMapping("/tags/blogs")
    public String bloglist(Integer pagenum,Long id,Model model){


        List<Tag> tags=tagService.findAll();

        model.addAttribute("tags",tags);

        int i=1;
        if(pagenum!=null){
            i=pagenum;

        }
        model.addAttribute("tagId",id);
        Page<Blog> blogs=blogService.findByTagIdAndPage(id,i);
        model.addAttribute("page",blogs);
        return "tags :: bloglist";
    }
}
