package com.chenxin.blog.mapper;

import com.chenxin.blog.entity.Blog;
import com.chenxin.blog.entity.BlogExample;
import com.chenxin.blog.entity.Comment;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {
    int countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);

    Page<Blog> getBlogByPaging(Blog blog);

    Page<Blog> findBlogByPaging();

    Blog getBlogById(Long id);

    Page<Blog> getSearchPage(String query);

    Blog findBlogById(Long id);


    Page<Blog> findBlogByTypeIdAndPage(Long id);

    Page<Blog> findBlogByTagIdAndPage(Long id);

    List<String> findYear();

    List<Blog> findBlogByYear(String year);
}