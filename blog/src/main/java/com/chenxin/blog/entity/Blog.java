package com.chenxin.blog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blog implements Serializable {
    private Long id;//id

    private String title;//标题

    private String content;//内容

    private String firstpicture;//首图

    private String flag;//标记

    private String description;//描述

    private Integer viewcount;//浏览次数

    private Byte isadmire;//是否赞赏开启

    private Byte iscopyright;//是否版权开启

    private Byte isrecommend;//是否发布

    private Byte iscomment;//是否评论开启

    private Byte issue;//是否推荐

    private Date createtime;//创建时间

    private Date updatetime;//更新时间

    private Long userId;//用户id

    private Long typeId;//类别id

    private User user;//对应的用户

    private Type type;//类别

    private String tagsId;//标签的id(1,2,3)（用于封装参数）



    private List<Comment> comments=new ArrayList<>();//  评论

    private List<Tag> tags=new ArrayList<>();//  标签


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTagsId() {
        return tagsId;
    }

    public void setTagsId(String tagsId) {
        this.tagsId = tagsId;
    }

    public Byte getIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(Byte isrecommend) {
        this.isrecommend = isrecommend;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFirstpicture() {
        return firstpicture;
    }

    public void setFirstpicture(String firstpicture) {
        this.firstpicture = firstpicture == null ? null : firstpicture.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Integer getViewcount() {
        return viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    public Byte getIsadmire() {
        return isadmire;
    }

    public void setIsadmire(Byte isadmire) {
        this.isadmire = isadmire;
    }

    public Byte getIscopyright() {
        return iscopyright;
    }

    public void setIscopyright(Byte iscopyright) {
        this.iscopyright = iscopyright;
    }

    public Byte getIscomment() {
        return iscomment;
    }

    public void setIscomment(Byte iscomment) {
        this.iscomment = iscomment;
    }

    public Byte getIssue() {
        return issue;
    }

    public void setIssue(Byte issue) {
        this.issue = issue;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstpicture='" + firstpicture + '\'' +
                ", flag='" + flag + '\'' +
                ", description='" + description + '\'' +
                ", viewcount=" + viewcount +
                ", isadmire=" + isadmire +
                ", iscopyright=" + iscopyright +
                ", isrecommend=" + isrecommend +
                ", iscomment=" + iscomment +
                ", issue=" + issue +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", user=" + user +
                ", type=" + type +
                ", tagsId='" + tagsId + '\'' +
                ", comments=" + comments +
                ", tags=" + tags +
                '}';
    }

    /**
     * 把查询出来的tag集合转换为（1,2,3）的字符串
     */
    public void initTagIds() {

        if (getTags() != null) {
            StringBuffer sb=new StringBuffer();
            boolean f=false;
            for (Tag t : tags
            ) {
                if(f){
                    sb.append(",");

                  }else {
                    f=true;
                 }
                sb.append(t.getId());
            }

            this.setTagsId(sb.toString());
        }
    }
}