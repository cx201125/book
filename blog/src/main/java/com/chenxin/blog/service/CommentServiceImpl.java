package com.chenxin.blog.service;

import com.chenxin.blog.entity.Comment;
import com.chenxin.blog.entity.User;

import java.util.List;

public interface CommentServiceImpl {
    /**
     * 获取博客评论列表
     * @param blogId
     * @return
     */
    List<Comment> findCommentList(Long blogId);

    /**
     * 保存评论
     * @param comment
     * @return
     */
    int saveComment(Comment comment, User user);
}
