package com.chenxin.blog.service;

import com.chenxin.blog.entity.Blog_TagExample;
import com.chenxin.blog.entity.Tag;
import com.chenxin.blog.entity.TagExample;
import com.chenxin.blog.entity.Type;
import com.chenxin.blog.mapper.Blog_TagMapper;
import com.chenxin.blog.mapper.TagMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheNames = "/tag")
public class TagService implements TagServiceImpl{
    @Autowired
    TagMapper tagMapper;
    @Autowired
    Blog_TagMapper blog_tagMapper;
    TagExample tagExample=new TagExample();
    @Value("${blog.admain.pageSize}")
    private Integer pageSize;
    @Value("${blog.tag.topNumber}")
    private Integer topNum;

    Blog_TagExample blog_tagExample=new Blog_TagExample();
    @Override
    public Tag findById(Long id) {
        Tag tag = tagMapper.selectByPrimaryKey(id);
        return tag;
    }

    @Override
    //@Cacheable(key = "#pageNum+#pageSize")
    public Page<Tag> findByPage(Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);

        Page<Tag> data = tagMapper.findByPaging();

     return data;
    }

    @Override
   // @CacheEvict(cacheNames = "/type")
    public int saveTag(Tag tag) {
        int insert = tagMapper.insert(tag);
        return insert;
    }

    @Override
    public Tag getByName(Tag tag) {
        TagExample.Criteria criteria = tagExample.createCriteria().andNameEqualTo(tag.getName());
        List<Tag> types = tagMapper.selectByExample(tagExample);
        tagExample.clear();
        if(types.size()>=1){
            return types.get(0);
        }else{
            return null;
        }
    }

    @Override
    @Transactional
    public int editTag(Tag tag) {
        int i = tagMapper.updateByPrimaryKey(tag);
        return i;
    }

    @Override
    @Transactional
    public int removeTag(Long id) {
        int i = tagMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public List<Tag> getAll() {
        List<Tag> tags = tagMapper.selectByExample(tagExample);
        return tags;
    }


    @Override
    public List<Tag> getTop() {

        tagExample.setLimit(0,topNum);
        List<Tag> tags = tagMapper.findByExample(tagExample);
        tagExample.clear();

        return tags;
    }

    @Override
    public List<Tag> findAll() {
        List<Tag> tags = tagMapper.findByExample(tagExample);
        tagExample.clear();

        return tags;
    }
}
