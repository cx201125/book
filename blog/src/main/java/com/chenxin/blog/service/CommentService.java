package com.chenxin.blog.service;

import com.chenxin.blog.entity.Comment;
import com.chenxin.blog.entity.CommentExample;
import com.chenxin.blog.entity.User;
import com.chenxin.blog.mapper.BlogMapper;
import com.chenxin.blog.mapper.CommentMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService implements CommentServiceImpl {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    BlogMapper blogMapper;
    //头像
    @Value("${blog.comment.headportrait}")
    private String headportrait;
    CommentExample commentExample=new CommentExample();
    @Override
    public List<Comment> findCommentList(Long blogId) {
        commentExample.setOrderByClause("createtime desc");
        commentExample.createCriteria().andBlogIdEqualTo(blogId).andTopIdIsNull();
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        commentExample.clear();
        List<Comment> comments1 = eachComment(comments);
        return comments1;
    }

    /**
     * 循环每个顶级的评论节点
     * @param comments
     * @return
     */
    private List<Comment> eachComment(List<Comment> comments) {
        List<Comment> lc=new ArrayList<>();
        for (Comment comment : comments) {
            List<Comment> commentByTopId = findCommentByTopId(comment.getId());
            comment.setBottom(commentByTopId);
            iteratorGain(comment);
          // comment.setBottom(bottom);

            lc.add(comment);
            //bottom=new ArrayList<>();
        }
        //合并评论的各层子代到第一级子代集合中
        combineChildren(lc);
        return lc;
    }

    /**
     * 迭代查找评论的子评论
     * @param comment
     */
    //private List<Comment> bottom=new ArrayList<>();
    private void iteratorGain(Comment comment) {
        if(comment.getBottom()!=null){
            for (Comment c1:comment.getBottom()
            ) {
               // bottom.add(c1);
                List<Comment> commentByTopId1 = findCommentByTopId(c1.getId());

                c1.setBottom(commentByTopId1);

                iteratorGain(c1);

            }
        }
    }

    /**
     * 根据上一级的id查询
     * @param id
     * @return
     */
    public List<Comment> findCommentByTopId(Long id){
        commentExample.setOrderByClause("createtime desc");
    commentExample.createCriteria().andTopIdEqualTo(id);
    List<Comment> comments = commentMapper.selectByExample(commentExample);
    commentExample.clear();
    return comments;
}

    @Override
    @Transactional
    public int saveComment(Comment comment, User user) {
        if(user!=null){
            comment.setHeadportrait(user.getHeadportrait());
            comment.setIsadmain((byte) 0);
            comment.setCreatetime(new Date());

        }else{
            comment.setCreatetime(new Date());
            comment.setHeadportrait(headportrait);
        }


        if(comment.getTopId()==-1){
            comment.setTopId(null);
        }
        int i = commentMapper.insertSelective(comment);
        return i;
    }

    /**
     * 循环每个顶级的评论节点
     * @param comments
     * @return
     */


    /**
     *
     * @param comments root根节点，blog不为空的对象集合
     * @return
     */
    private void combineChildren(List<Comment> comments) {

        for (Comment comment : comments) {
            List<Comment> replys1 = comment.getBottom();

            for(Comment reply1 : replys1) {

                //循环迭代，找出子代，存放在tempReplys中
                recursively(reply1);
            }
            //修改顶级节点的reply集合为迭代处理后的集合

            comment.setBottom(tempReplys);

            //清除临时存放区
            tempReplys =new ArrayList<>();
            //System.out.println("===================================================="+tempReplys);
        }
    }

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();
    /**
     * 递归迭代，剥洋葱
     * @param comment 被迭代的对象
     * @return
     */
    private void recursively(Comment comment) {
        tempReplys.add(comment);//顶节点添加到临时存放集合
        if (comment.getBottom().size()>0) {
            List<Comment> replys = comment.getBottom();
            comment.setBottom(null);
            for (Comment reply : replys) {
                tempReplys.add(reply);
                reply.setTop(comment);
                if (reply.getBottom().size()>0) {
                    recursively(reply);
                }
            }
        }
    }
}
