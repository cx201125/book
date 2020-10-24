package com.chenxin.blog.controller;

import com.chenxin.blog.entity.Blog;
import com.chenxin.blog.entity.Type;
import com.chenxin.blog.service.BlogServiceImpl;
import com.chenxin.blog.service.TypeServiceImpl;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TypeController {
    @Autowired
    TypeServiceImpl typeService;
    @Autowired
    BlogServiceImpl blogService;
    @GetMapping("/types")
    public String typelist(Integer pagenum,Long id,Model model){

        List<Type> types=typeService.findAll();
        model.addAttribute("types",types);

            int i=1;
            if(pagenum!=null){
                i=pagenum;

            }
            if(id==null){
                id=types.get(0).getId();
            }

            Page<Blog> blogs=blogService.findByTypeIdAndPage(id,i);
            model.addAttribute("page",blogs);


        return "types";
    }
    @PostMapping("/types/blogs")
    public String bloglist(Integer pagenum,Long id,Model model){
        List<Type> types=typeService.findAll();
        model.addAttribute("types",types);
        int i=1;
        if(pagenum!=null){
            i=pagenum;

        }

        Page<Blog> blogs=blogService.findByTypeIdAndPage(id,i);
        model.addAttribute("page",blogs);
        return "types :: bloglist";
    }
}
