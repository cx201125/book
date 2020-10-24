package com.chenxin.blog.service;

import com.chenxin.blog.entity.Type;
import com.github.pagehelper.Page;

import java.util.List;

public interface TypeServiceImpl {
    /**
     * 根据id查询
     * @return
     */
     Type findById(Long id);


    /**
     * 根据分页查询
     * @param pagenum
     *
     * @return
     */
    Page<Type> findByPage(Integer pagenum);

    /**
     * 保存类别
     * @param type
     * @return
     */
    int saveType(Type type);

    /**
     * 根据类别名称查询（用于验证有没有相同的类别名称）
     * @param type
     * @return
     */
    Type getByName(Type type);

    /**
     * 编辑用户
     * @param type
     * @return
     */
    int editType(Type type);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int removeType(Long id);

    /**
     * 查询全部分类，用于博客列表的类别展示
     * @return
     */
    List<Type> getAll();

    /**
     * 获取类别排序的前面几个
     * @return
     */
    List<Type> getTop();

    /**
     * 获取全部类别按照博客数量的降序排序
     * @return
     */
    List<Type> findAll();
}
