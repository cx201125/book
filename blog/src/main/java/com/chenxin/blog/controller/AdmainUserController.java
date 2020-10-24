package com.chenxin.blog.controller;


import com.chenxin.blog.entity.User;

import com.chenxin.blog.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admain")
public class AdmainUserController {
    @Autowired
    UserServiceImpl userService;

  //用户登录验证
    @PostMapping ("/login")
    public String login(User user, HttpSession session, RedirectAttributes redirectAttributes,Model model){
        String returned=null;
        User u = userService.LoginVerify(user);
            if(u!=null){
                u.setPassword(null);
                session.setAttribute("user",u);
                returned="redirect:/admain/index";
              //  System.out.println(u);
            }else{
              redirectAttributes.addFlashAttribute("hint","用户名或者密码错误");
              //model.addAttribute("hint","用户名或者密码错误");
                returned="redirect:/admain";
            }

                 return returned;
    }
    @GetMapping ("/write")
    public String write(HttpSession session){
        session.removeAttribute("user");
        return "admain/login";
    }


}
