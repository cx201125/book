package com.chenxin.blog.mapper;

import com.chenxin.blog.entity.Tag;
import com.chenxin.blog.entity.TagExample;
import com.chenxin.blog.entity.Type;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper {
    int countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    /**
     * 分页查询
     * @return
     */
    Page<Tag> findByPaging();

    List<Tag> findByExample(TagExample tagExample);

    /**
     * 根据博客id查询
     * @param id
     * @return
     */
    List<Tag> findByBlogId(Long id);
}