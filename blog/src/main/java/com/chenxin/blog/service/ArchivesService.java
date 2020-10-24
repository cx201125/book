package com.chenxin.blog.service;

import com.chenxin.blog.entity.Blog;
import com.chenxin.blog.entity.BlogExample;
import com.chenxin.blog.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArchivesService implements  ArchivesServiceImpl{
    @Autowired
    private BlogMapper blogMapper;
     BlogExample blogExample=new BlogExample();
    @Override
    public Integer fingBlogCount() {
        int i = blogMapper.countByExample(blogExample);
        return i;
    }

    @Override
    public Map<String, List<Blog>> findBlogByData() {
        Map<String, List<Blog>> map=new LinkedHashMap<>();
        List<String> years=blogMapper.findYear();
        for (String year:years
             ) {

            List<Blog> blogs=blogMapper.findBlogByYear(year);
            map.put(year,blogs);
        }
        return map;
    }
}
