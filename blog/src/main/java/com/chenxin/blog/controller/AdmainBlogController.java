package com.chenxin.blog.controller;

import com.chenxin.blog.entity.Blog;
import com.chenxin.blog.entity.Tag;
import com.chenxin.blog.entity.Type;
import com.chenxin.blog.entity.User;
import com.chenxin.blog.service.BlogServiceImpl;
import com.chenxin.blog.service.TagServiceImpl;
import com.chenxin.blog.service.TypeServiceImpl;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admain")
public class AdmainBlogController {
    @Autowired
    BlogServiceImpl blogService;
    @Autowired
    TypeServiceImpl typeService;
    @Autowired
    TagServiceImpl tagService;
    @GetMapping("/listblogs")
    public String types(Integer pageNum, Model model,Blog blog){
        int i=1;
        if(pageNum!=null){
            i=pageNum;

        }
        Page<Blog> byPage = blogService.findByPage(i,blog);
        model.addAttribute("page",byPage);
        //分类列表
       List<Type> listtype=typeService.getAll();
       model.addAttribute("alltype",listtype);
        return "admain/blogs";
    }

    @PostMapping("/listblogs/search")
    public String search(Integer pageNum, Model model,Blog blog){
       // System.out.println(" blog ======== " + blog);
        //System.out.println("pageNum =========== " + pageNum + ", model = " + model + ", blog = " + blog);
        int i=1;

        if(blog.getIssue()==2){
            blog.setIssue(null);
        }
        if(blog.getIsrecommend()==2){
            blog.setIsrecommend(null);
        }

        if(pageNum!=null){
            i=pageNum;

        }
        Page<Blog> byPage = blogService.findByPage(i, blog);
        model.addAttribute("page",byPage);
        return "admain/blogs :: bloglist";
    }
//前往新增博客
    @GetMapping("/addblog")
    public String addblogspage(Model model){
        //分类列表
        List<Type> listtype=typeService.getAll();
        model.addAttribute("alltype",listtype);
        //标签列表
        List<Tag> all = tagService.getAll();
        model.addAttribute("alltag",all);

        return "admain/blogs-input";
    }
    //前往编辑博客
    @GetMapping("/editblog/{id}")
    public String addblogspage(Model model,@PathVariable Long id){
        //分类列表
        List<Type> listtype=typeService.getAll();
        model.addAttribute("alltype",listtype);
        //标签列表
        List<Tag> all = tagService.getAll();
        model.addAttribute("alltag",all);
        //博客
        Blog blog=blogService.getBlogById(id);
        model.addAttribute("blog",blog);
        return "admain/blogs-input";
    }

    //删除博客
    @GetMapping("/removeblog/{id}")
    public String removeblogs(Model model,@PathVariable Long id,RedirectAttributes redirectAttributes){


        int i = blogService.removeblog(id);
        if (i < 1) {
            redirectAttributes.addFlashAttribute("hint", "编辑失败");
        } else {
            redirectAttributes.addFlashAttribute("hint", "编辑成功");
        }
        return "redirect:/admain/listblogs";
    }

    @PostMapping("/saveblog")
    public String save(Blog blog, HttpSession session, RedirectAttributes redirectAttributes){
        if(blog.getId()!=null) {
            //编辑
            blog.setIsrecommend((byte) 1);

            int i = blogService.editblog(blog);
            if (i < 1) {
                redirectAttributes.addFlashAttribute("hint", "编辑失败");
            } else {
                redirectAttributes.addFlashAttribute("hint", "编辑成功");
            }
        }else {
            //初始化blog
            User user = (User) session.getAttribute("user");
            blog.setUserId(user.getId());
            //是否发布这里是保存
            blog.setIsrecommend((byte) 1);

            int i = blogService.saveBlog(blog);
            if (i < 1) {
                redirectAttributes.addFlashAttribute("hint", "保存失败");
            } else {
                redirectAttributes.addFlashAttribute("hint", "保存成功");
            }
        }
        return "redirect:/admain/listblogs";
    }

    @PostMapping("/issueblog")
    public String issue(Blog blog, HttpSession session, RedirectAttributes redirectAttributes){

        if(blog.getId()!=null){
            //编辑
            blog.setIsrecommend((byte) 0);

            int i=blogService.editblog(blog);
            if (i < 1) {
                redirectAttributes.addFlashAttribute("hint", "编辑失败");
            } else {
                redirectAttributes.addFlashAttribute("hint", "编辑成功");
            }
        }else {
            //发布
            //封装参数
            User user = (User) session.getAttribute("user");
            blog.setUserId(user.getId());
            //是否发布这里是发布
            blog.setIsrecommend((byte) 0);
            int i = blogService.saveBlog(blog);

            if (i < 1) {
                redirectAttributes.addFlashAttribute("hint", "发布失败");
            } else {
                redirectAttributes.addFlashAttribute("hint", "发布成功");
            }
        }
        return "redirect:/admain/listblogs";
    }
}
