package com.chenxin.blog.service;

import com.chenxin.blog.entity.Blog;
import com.chenxin.blog.entity.Type;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface BlogServiceImpl {
    /**
     * 根据分页查询
     * @param pagenum
     * @return
     */
    Page<Blog> findByPage(Integer pagenum,Blog blog);

    /**
     * 保存博客
     * @param blog
     * @return
     */
    int saveBlog(Blog blog);

    /**
     * 根据id获取博客
     * @param id
     * @return
     */
    Blog getBlogById(Long id);

    /**
     * 编辑博客
     * @param blog
     * @return
     */
    int editblog(Blog blog);

    /**
     * 删除博客
     * @param id
     * @return
     */
    int removeblog(Long id);

    /**
     * 没有条件的分页查询
     * @param pageNum
     * @return
     */
    Page<Blog> findByPage(Integer pageNum);

    /**
     * 获取推荐的按照时间的TopN
     * @return
     */
    List<Blog> getIsRecommend(Integer top);

    /**
     * 用于搜索的分页查询
     * @param pageNum
     * @param query
     * @return
     */
    Page<Blog> getSearchPage(Integer pageNum, String query);

    /**
     * 根据id获取博客，包括评论
     * @param id
     * @return
     */
    Blog findBlogById(Long id);

    /**
     * 根据类别的id查询
     * @return
     */
    Page<Blog> findByTypeIdAndPage(Long typeId,Integer pagenum);

    /**
     * 根据博客标签id查询
     * @param id
     * @param i
     * @return
     */
    Page<Blog> findByTagIdAndPage(Long id, Integer pagenum);
}
