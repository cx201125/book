package com.chenxin.blog.service;

import com.chenxin.blog.entity.Tag;
import com.chenxin.blog.entity.Type;
import com.github.pagehelper.Page;

import java.util.List;

public interface TagServiceImpl {
    /**
     * 根据id查询
     * @return
     */
     Tag findById(Long id);


    /**
     * 根据分页查询
     * @param pagenum
     * @param pagesize
     * @return
     */
    Page<Tag> findByPage(Integer pagenum);

    /**
     * 保存类别
     * @param tag
     * @return
     */
    int saveTag(Tag tag);

    /**
     * 根据类别名称查询（用于验证有没有相同的类别名称）
     * @param tag
     * @return
     */
    Tag getByName(Tag tag);

    /**
     * 编辑用户
     * @param tag
     * @return
     */
    int editTag(Tag tag);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int removeTag(Long id);

    /**
     * 获取全部标签
     * @return
     */
    List<Tag> getAll();

    /**
     * 获取标签的TOPN
     * @return
     */
    List<Tag> getTop();

    /**
     * 查詢所有的标签用于前端标签列表的展示
     * @return
     */
    List<Tag> findAll();
}
