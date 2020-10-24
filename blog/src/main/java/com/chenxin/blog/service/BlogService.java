package com.chenxin.blog.service;

import com.chenxin.blog.entity.*;

import com.chenxin.blog.mapper.BlogMapper;
import com.chenxin.blog.mapper.Blog_TagMapper;
import com.chenxin.blog.mapper.TagMapper;
import com.chenxin.blog.utils.MarkdownUtils;
import com.github.pagehelper.Page;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class BlogService implements BlogServiceImpl {
    @Value("${blog.admain.pageSize}")
    private Integer admainpageSize;
    @Value("${blog.front.pageSize}")
    private Integer frontpageSize;
    @Value("${blog.topNumber}")
    private  Integer topNum;
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    Blog_TagMapper blog_tagMapper;
    @Autowired
    TagMapper tagMapper;
    Blog_TagExample blog_TagExample=new Blog_TagExample();

    BlogExample blogExample=new BlogExample();
    @Override
    public Page<Blog> findByPage(Integer pagenum,Blog blog) {
        PageHelper.startPage(pagenum,admainpageSize);
        Page<Blog> blogByPaging = blogMapper.getBlogByPaging(blog);
        return blogByPaging;
    }

    @Override
    public int saveBlog(Blog blog) {
        //封装参数
        blog.setCreatetime(new Date());
        blog.setUpdatetime(new Date());
        blog.setViewcount(0);

        //判断checked的状态
        if (blog.getIsadmire() == null) {
            blog.setIsadmire((byte) 1);
        }
        if (blog.getIscopyright() == null) {
            blog.setIscopyright((byte) 1);
        }
        if (blog.getIscomment() == null) {
            blog.setIscomment((byte) 1);
        }
        if (blog.getIssue() == null) {
            blog.setIssue((byte) 1);
        }

        Integer i = blogMapper.insert(blog);

        if(i<1){
            return i;
        }
        this.saveTag_Blog(blog);
        return i;
    }

    @Override
    public Blog getBlogById(Long id) {
       Blog blog= blogMapper.getBlogById(id);
       blog.initTagIds();//初始化标签id
       return blog;
    }
    //保存博客和tagid的中间表
    @Transactional
public void saveTag_Blog(Blog blog){
    if(!StringUtils.isEmpty(blog.getTagsId())) {
        Blog_Tag blog_tag = new Blog_Tag();
        String[] tagids = blog.getTagsId().split(",");
        for (String s:tagids
        ) {
            blog_tag.setBlogId(blog.getId());
            blog_tag.setTagId(Long.parseLong(s));
            blog_tagMapper.insert(blog_tag);
        }

    }
}
    @Override
    @Transactional
    public int editblog(Blog blog) {
        blog.setUpdatetime(new Date());
       int i= blogMapper.updateByPrimaryKeySelective(blog);
        if(i<1){
            return i;
        }
        //先删除关联博客的全部id
        blog_TagExample.createCriteria().andBlogIdEqualTo(blog.getId());
        int i1 = blog_tagMapper.deleteByExample(blog_TagExample);
        blog_TagExample.clear();
        //保存
            this.saveTag_Blog(blog);

        return i;
    }

    @Override
    @Transactional
    public int removeblog(Long id) {
        int i = blogMapper.deleteByPrimaryKey(id);
        if(i<1){
            return i;
        }
        blog_TagExample.createCriteria().andBlogIdEqualTo(id);
        int i1 = blog_tagMapper.deleteByExample(blog_TagExample);
        blog_TagExample.clear();
        return i;
    }

    @Override
    public Page<Blog> findByPage(Integer pagenum) {
        PageHelper.startPage(pagenum,frontpageSize);
        Page<Blog> blogByPaging = blogMapper.findBlogByPaging();
        return blogByPaging;
    }

    @Override
    public List<Blog> getIsRecommend(Integer top) {
        blogExample.setOrderByClause("updatetime DESC");
        Integer topNumber=topNum;
        if(top!=null){
            topNumber=top;
        }
        blogExample.setLimit(0,topNumber);
        List<Blog> blogs = blogMapper.selectByExample(blogExample);
        blogExample.clear();
        return blogs;
    }

    @Override
    public Page<Blog> getSearchPage(Integer pageNum, String query) {
        PageHelper.startPage(pageNum,frontpageSize);
       Page<Blog> page= blogMapper.getSearchPage(query);
       return page;
    }

    @Override
    public Blog findBlogById(Long id) {
        Blog blogById = blogMapper.findBlogById(id);
        String s = MarkdownUtils.markdownToHtmlExtensions(blogById.getContent());
        blogById.setContent(s);
        //刷新博客的viewCount
        Blog bl=new Blog();
        bl.setViewcount(blogById.getViewcount()+1);
        bl.setId(blogById.getId());
        int i = blogMapper.updateByPrimaryKeySelective(bl);
        return blogById;
    }

    @Override
    public Page<Blog> findByTypeIdAndPage(Long id,Integer pagenum) {
        PageHelper.startPage(pagenum,frontpageSize);
        Page<Blog> blogs = blogMapper.findBlogByTypeIdAndPage(id);

        return blogs;
    }

    private Page<Blog>  setPageByTag(Page<Blog> blogs){
        for (int i = 0; i <blogs.size() ; i++) {

            Blog blog = blogs.remove(0);

            List<Tag> tags = tagMapper.findByBlogId(blog.getId());
            blog.setTags(tags);
            blogs.add(blog);
        }

        return blogs;
    }
    @Override
    public Page<Blog> findByTagIdAndPage(Long id, Integer pagenum) {
        PageHelper.startPage(pagenum,frontpageSize);
        Page<Blog> blogs= blogMapper.findBlogByTagIdAndPage(id);
        Page<Blog> blogs1 = setPageByTag(blogs);

        return blogs1;
    }
}
