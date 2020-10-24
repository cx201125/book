package com.chenxin.blog.service;

import com.chenxin.blog.entity.Blog;

import java.util.List;
import java.util.Map;

public interface ArchivesServiceImpl {
    /**
     * 查询博客的总数
     * @return
     */
    Integer fingBlogCount();

    /**
     * 按照更新日期查询
     * key：年份
     * value：对应年份的博客
     * @return
     */
    Map<String, List<Blog>> findBlogByData();
}
