package com.chenxin.blog.controller;

import com.chenxin.blog.entity.Comment;
import com.chenxin.blog.entity.User;
import com.chenxin.blog.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;
   @GetMapping("/comments/{blogId}")
    public String comment(@PathVariable Long blogId, Model model) {
       List<Comment> commentList =commentService.findCommentList(blogId);
       model.addAttribute("comments",commentList);
        return "blog :: commentlist";
    }

    @PostMapping("/comments")
    public String comment(Comment comment, HttpSession session) {

        User user = (User) session.getAttribute("user");
        int i=commentService.saveComment(comment,user);

        return "redirect:/comments/"+comment.getBlogId();
    }
}
