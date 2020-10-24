package com.chenxin.blog.controller;

import com.chenxin.blog.entity.Blog;
import com.chenxin.blog.service.ArchivesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ArchivesController {
    @Autowired
    ArchivesServiceImpl archivesService;
    @GetMapping("/archives")
    public String  archives(Model model){
        //博客的总数
       Integer bc= archivesService.fingBlogCount();
        model.addAttribute("blogCount",bc);

       Map<String, List<Blog>> mb= archivesService.findBlogByData();
        model.addAttribute("blogs",mb);
        return "archives";
    }
}
