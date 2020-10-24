package com.chenxin.blog.controller;

import com.chenxin.blog.entity.Blog;
import com.chenxin.blog.entity.Tag;
import com.chenxin.blog.entity.Type;
import com.chenxin.blog.service.BlogServiceImpl;
import com.chenxin.blog.service.TagService;
import com.chenxin.blog.service.TagServiceImpl;
import com.chenxin.blog.service.TypeServiceImpl;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IndexController{
    @Autowired
    BlogServiceImpl blogService;
    @Autowired
    TypeServiceImpl typeService;
    @Autowired
    TagServiceImpl tagService;
    @GetMapping("/")
    public String indexoage(Integer pageNum, Model model){
        int i=1;
        if(pageNum!=null){
            i=pageNum;

        }
        Page<Blog> byPage = blogService.findByPage(i);

        model.addAttribute("page",byPage);
        //分类TOP
        List<Type> listtype=typeService.getTop();
        model.addAttribute("toptype",listtype);

        //标签Top
        List<Tag> tagtop = tagService.getTop();
        //System.out.println(tagtop);
        model.addAttribute("toptag",tagtop);

        //博客推荐
        List<Blog> blogs = blogService.getIsRecommend(null);
        model.addAttribute("topblog",blogs);
        return "index";
    }
    @PostMapping("/search")
    public String Search(String query,Model model,Integer pageNum){
       // System.out.println(query);
        int i=1;
        if(pageNum!=null){
            i=pageNum;

        }
        Page pagelist=blogService.getSearchPage(i,query);
        model.addAttribute("page",pagelist);
        return "search";
    }
    @GetMapping("/fragments/newblog")
    public String newblogs(Model model){

        List<Blog> isRecommend = blogService.getIsRecommend(3);
        //System.out.println(isRecommend);
        model.addAttribute("newblogs",isRecommend);
        return "common/fragments :: newbloglist";

    }
}
