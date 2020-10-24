package com.chenxin.blog;

import com.chenxin.blog.entity.*;
import com.chenxin.blog.mapper.BlogMapper;
import com.chenxin.blog.mapper.TagMapper;
import com.chenxin.blog.mapper.TypeMapper;
import com.chenxin.blog.service.CommentService;
import com.chenxin.blog.service.CommentServiceImpl;
import com.chenxin.blog.service.TypeService;
import com.github.pagehelper.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
DataSource dataSource;
    @Autowired
    TagMapper tagMapper;
    @Autowired
    TypeService typeService;
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    CommentService commentService;
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }
    @Test
    void contextLoads1() throws SQLException {
        Tag tag = tagMapper.selectByPrimaryKey(1l);
    }

    @Test
    void contextLoads2() throws SQLException {
        Page<Type> byPage = typeService.findByPage(1);
        System.out.println(byPage);
    }

    @Test
    void contextLoads3() throws SQLException {
        //List<Blog> allBlog = blogMapper.getAllBlog();
//        Blog blog = allBlog.get(0);
//        System.out.println(blog);

    }

    @Test
    void contextLoads4() throws SQLException {
        Blog blogById = blogMapper.getBlogById(15L);
        System.out.println(blogById);
       List<Tag> tags = blogById.getTags();
        for (Tag t:tags
             ) {
            System.out.println(t);
        }
    }
    @Test
    void contextLoads5() throws SQLException {
        List<Comment> commentList = commentService.findCommentList(19L);
        System.out.println(commentList);
    }
    @Autowired
private About about;
    @Test
    void contextLoads6() throws SQLException {
        System.out.println(about);
    }
}
