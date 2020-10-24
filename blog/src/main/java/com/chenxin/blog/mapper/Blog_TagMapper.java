package com.chenxin.blog.mapper;

import com.chenxin.blog.entity.Blog_Tag;
import com.chenxin.blog.entity.Blog_TagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Blog_TagMapper {
    int countByExample(Blog_TagExample example);

    int deleteByExample(Blog_TagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Blog_Tag record);

    int insertSelective(Blog_Tag record);

    List<Blog_Tag> selectByExample(Blog_TagExample example);

    Blog_Tag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Blog_Tag record, @Param("example") Blog_TagExample example);

    int updateByExample(@Param("record") Blog_Tag record, @Param("example") Blog_TagExample example);

    int updateByPrimaryKeySelective(Blog_Tag record);

    int updateByPrimaryKey(Blog_Tag record);
}