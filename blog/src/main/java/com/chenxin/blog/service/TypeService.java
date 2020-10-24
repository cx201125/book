package com.chenxin.blog.service;

import com.chenxin.blog.entity.BlogExample;
import com.chenxin.blog.entity.Type;
import com.chenxin.blog.entity.TypeExample;
import com.chenxin.blog.entity.UserExample;
import com.chenxin.blog.mapper.BlogMapper;
import com.chenxin.blog.mapper.TagMapper;
import com.chenxin.blog.mapper.TypeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheNames = "/type")
public class TypeService implements TypeServiceImpl {
    @Value("${blog.admain.pageSize}")
    private Integer pageSize;
    @Value("${blog.type.topNumber}")
    private Integer topNum;
    @Autowired
    TypeMapper typeMapper;
    @Autowired
    BlogMapper blogMapper;
    TypeExample typeExample=new TypeExample();
    BlogExample blogExample=new BlogExample();
    @Override
    public Type findById(Long id) {
        Type type = typeMapper.selectByPrimaryKey(id);
        return type;
    }

    @Override
   // @Cacheable(key = "#pageNum")
    public Page<Type> findByPage(Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);

        Page<Type> data = typeMapper.findByPaging();

     return data;
    }

    @Override
    @Transactional
  //  @CacheEvict(value = "/type",allEntries = true,beforeInvocation = true)
    public int saveType(Type type) {
        int insert = typeMapper.insert(type);
        return insert;
    }

    @Override
    public Type getByName(Type type) {
        TypeExample.Criteria criteria = typeExample.createCriteria().andNameEqualTo(type.getName());
        List<Type> types = typeMapper.selectByExample(typeExample);
        typeExample.clear();
        if(types.size()>=1){
            return types.get(0);
        }else{
            return null;
        }
    }

    @Override
    @Transactional
    public int editType(Type type) {
        int i = typeMapper.updateByPrimaryKey(type);
        return i;
    }

    @Override
    @Transactional
    //@CacheEvict(value = "/type",allEntries = true)
    public int removeType(Long id) {
        int i = typeMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public List<Type> getAll() {
        List<Type> types = typeMapper.selectByExample(typeExample);
        return types;
    }

    @Override
    public List<Type> getTop() {

        typeExample.setLimit(0,topNum);
        List<Type> types = typeMapper.findByExample(typeExample);
        typeExample.clear();


        return types;
    }

    @Override
    public List<Type> findAll() {
        List<Type> types = typeMapper.findByExample(typeExample);
        typeExample.clear();
        return types;
    }
}
