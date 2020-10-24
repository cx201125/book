package com.chenxin.blog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment implements Serializable {
    private Long id;//id

    private String petname;//昵称

    private String mail;//邮箱

    private String headportrait;//头像

    private String matter;//内容

    private Date createtime;//创建时间

    private Byte isadmain;

    private Long blogId;//博客id

    private  Blog blog;//博客详情

    private Long topId;//上级评论id

    private Comment top;//评论的上级评论

    private List<Comment> bottom=new ArrayList<>();//评论的下级评论
    private static final long serialVersionUID = 1L;

    public Byte getIsadmain() {
        return isadmain;
    }

    public void setIsadmain(Byte isadmain) {
        this.isadmain = isadmain;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Comment getTop() {
        return top;
    }

    public void setTop(Comment top) {
        this.top = top;
    }

    public List<Comment> getBottom() {
        return bottom;
    }

    public void setBottom(List<Comment> bottom) {
        this.bottom = bottom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname == null ? null : petname.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait == null ? null : headportrait.trim();
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter == null ? null : matter.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getTopId() {
        return topId;
    }

    public void setTopId(Long topId) {
        this.topId = topId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", petname='" + petname + '\'' +
                ", mail='" + mail + '\'' +
                ", headportrait='" + headportrait + '\'' +
                ", matter='" + matter + '\'' +
                ", createtime=" + createtime +
                ", blogId=" + blogId +
                ", blog=" + blog +
                ", topId=" + topId +
                ", top=" + top +
                ", bottom=" + bottom +
                '}';
    }
}