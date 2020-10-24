package com.chenxin.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {

    protected Integer begin;
    protected  Integer end;
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public void setLimit(Integer begin,Integer end){
        this.begin=begin;
        this.end=end;
    }

    public BlogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        begin=null;
        end=null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andFirstpictureIsNull() {
            addCriterion("firstPicture is null");
            return (Criteria) this;
        }

        public Criteria andFirstpictureIsNotNull() {
            addCriterion("firstPicture is not null");
            return (Criteria) this;
        }

        public Criteria andFirstpictureEqualTo(String value) {
            addCriterion("firstPicture =", value, "firstpicture");
            return (Criteria) this;
        }

        public Criteria andFirstpictureNotEqualTo(String value) {
            addCriterion("firstPicture <>", value, "firstpicture");
            return (Criteria) this;
        }

        public Criteria andFirstpictureGreaterThan(String value) {
            addCriterion("firstPicture >", value, "firstpicture");
            return (Criteria) this;
        }

        public Criteria andFirstpictureGreaterThanOrEqualTo(String value) {
            addCriterion("firstPicture >=", value, "firstpicture");
            return (Criteria) this;
        }

        public Criteria andFirstpictureLessThan(String value) {
            addCriterion("firstPicture <", value, "firstpicture");
            return (Criteria) this;
        }

        public Criteria andFirstpictureLessThanOrEqualTo(String value) {
            addCriterion("firstPicture <=", value, "firstpicture");
            return (Criteria) this;
        }

        public Criteria andFirstpictureLike(String value) {
            addCriterion("firstPicture like", value, "firstpicture");
            return (Criteria) this;
        }

        public Criteria andFirstpictureNotLike(String value) {
            addCriterion("firstPicture not like", value, "firstpicture");
            return (Criteria) this;
        }

        public Criteria andFirstpictureIn(List<String> values) {
            addCriterion("firstPicture in", values, "firstpicture");
            return (Criteria) this;
        }

        public Criteria andFirstpictureNotIn(List<String> values) {
            addCriterion("firstPicture not in", values, "firstpicture");
            return (Criteria) this;
        }

        public Criteria andFirstpictureBetween(String value1, String value2) {
            addCriterion("firstPicture between", value1, value2, "firstpicture");
            return (Criteria) this;
        }

        public Criteria andFirstpictureNotBetween(String value1, String value2) {
            addCriterion("firstPicture not between", value1, value2, "firstpicture");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andViewcountIsNull() {
            addCriterion("viewcount is null");
            return (Criteria) this;
        }

        public Criteria andViewcountIsNotNull() {
            addCriterion("viewcount is not null");
            return (Criteria) this;
        }

        public Criteria andViewcountEqualTo(String value) {
            addCriterion("viewcount =", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotEqualTo(String value) {
            addCriterion("viewcount <>", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountGreaterThan(String value) {
            addCriterion("viewcount >", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountGreaterThanOrEqualTo(String value) {
            addCriterion("viewcount >=", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountLessThan(String value) {
            addCriterion("viewcount <", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountLessThanOrEqualTo(String value) {
            addCriterion("viewcount <=", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountLike(String value) {
            addCriterion("viewcount like", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotLike(String value) {
            addCriterion("viewcount not like", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountIn(List<String> values) {
            addCriterion("viewcount in", values, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotIn(List<String> values) {
            addCriterion("viewcount not in", values, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountBetween(String value1, String value2) {
            addCriterion("viewcount between", value1, value2, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotBetween(String value1, String value2) {
            addCriterion("viewcount not between", value1, value2, "viewcount");
            return (Criteria) this;
        }

        public Criteria andIsadmireIsNull() {
            addCriterion("isadmire is null");
            return (Criteria) this;
        }

        public Criteria andIsadmireIsNotNull() {
            addCriterion("isadmire is not null");
            return (Criteria) this;
        }

        public Criteria andIsadmireEqualTo(Byte value) {
            addCriterion("isadmire =", value, "isadmire");
            return (Criteria) this;
        }

        public Criteria andIsadmireNotEqualTo(Byte value) {
            addCriterion("isadmire <>", value, "isadmire");
            return (Criteria) this;
        }

        public Criteria andIsadmireGreaterThan(Byte value) {
            addCriterion("isadmire >", value, "isadmire");
            return (Criteria) this;
        }

        public Criteria andIsadmireGreaterThanOrEqualTo(Byte value) {
            addCriterion("isadmire >=", value, "isadmire");
            return (Criteria) this;
        }

        public Criteria andIsadmireLessThan(Byte value) {
            addCriterion("isadmire <", value, "isadmire");
            return (Criteria) this;
        }

        public Criteria andIsadmireLessThanOrEqualTo(Byte value) {
            addCriterion("isadmire <=", value, "isadmire");
            return (Criteria) this;
        }

        public Criteria andIsadmireIn(List<Byte> values) {
            addCriterion("isadmire in", values, "isadmire");
            return (Criteria) this;
        }

        public Criteria andIsadmireNotIn(List<Byte> values) {
            addCriterion("isadmire not in", values, "isadmire");
            return (Criteria) this;
        }

        public Criteria andIsadmireBetween(Byte value1, Byte value2) {
            addCriterion("isadmire between", value1, value2, "isadmire");
            return (Criteria) this;
        }

        public Criteria andIsadmireNotBetween(Byte value1, Byte value2) {
            addCriterion("isadmire not between", value1, value2, "isadmire");
            return (Criteria) this;
        }

        public Criteria andIscopyrightIsNull() {
            addCriterion("iscopyright is null");
            return (Criteria) this;
        }

        public Criteria andIscopyrightIsNotNull() {
            addCriterion("iscopyright is not null");
            return (Criteria) this;
        }

        public Criteria andIscopyrightEqualTo(Byte value) {
            addCriterion("iscopyright =", value, "iscopyright");
            return (Criteria) this;
        }

        public Criteria andIscopyrightNotEqualTo(Byte value) {
            addCriterion("iscopyright <>", value, "iscopyright");
            return (Criteria) this;
        }

        public Criteria andIscopyrightGreaterThan(Byte value) {
            addCriterion("iscopyright >", value, "iscopyright");
            return (Criteria) this;
        }

        public Criteria andIscopyrightGreaterThanOrEqualTo(Byte value) {
            addCriterion("iscopyright >=", value, "iscopyright");
            return (Criteria) this;
        }

        public Criteria andIscopyrightLessThan(Byte value) {
            addCriterion("iscopyright <", value, "iscopyright");
            return (Criteria) this;
        }

        public Criteria andIscopyrightLessThanOrEqualTo(Byte value) {
            addCriterion("iscopyright <=", value, "iscopyright");
            return (Criteria) this;
        }

        public Criteria andIscopyrightIn(List<Byte> values) {
            addCriterion("iscopyright in", values, "iscopyright");
            return (Criteria) this;
        }

        public Criteria andIscopyrightNotIn(List<Byte> values) {
            addCriterion("iscopyright not in", values, "iscopyright");
            return (Criteria) this;
        }

        public Criteria andIscopyrightBetween(Byte value1, Byte value2) {
            addCriterion("iscopyright between", value1, value2, "iscopyright");
            return (Criteria) this;
        }

        public Criteria andIscopyrightNotBetween(Byte value1, Byte value2) {
            addCriterion("iscopyright not between", value1, value2, "iscopyright");
            return (Criteria) this;
        }

        public Criteria andIscommentIsNull() {
            addCriterion("iscomment is null");
            return (Criteria) this;
        }

        public Criteria andIscommentIsNotNull() {
            addCriterion("iscomment is not null");
            return (Criteria) this;
        }

        public Criteria andIscommentEqualTo(Byte value) {
            addCriterion("iscomment =", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotEqualTo(Byte value) {
            addCriterion("iscomment <>", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentGreaterThan(Byte value) {
            addCriterion("iscomment >", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentGreaterThanOrEqualTo(Byte value) {
            addCriterion("iscomment >=", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentLessThan(Byte value) {
            addCriterion("iscomment <", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentLessThanOrEqualTo(Byte value) {
            addCriterion("iscomment <=", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentIn(List<Byte> values) {
            addCriterion("iscomment in", values, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotIn(List<Byte> values) {
            addCriterion("iscomment not in", values, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentBetween(Byte value1, Byte value2) {
            addCriterion("iscomment between", value1, value2, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotBetween(Byte value1, Byte value2) {
            addCriterion("iscomment not between", value1, value2, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIssueIsNull() {
            addCriterion("issue is null");
            return (Criteria) this;
        }

        public Criteria andIssueIsNotNull() {
            addCriterion("issue is not null");
            return (Criteria) this;
        }

        public Criteria andIssueEqualTo(Byte value) {
            addCriterion("issue =", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotEqualTo(Byte value) {
            addCriterion("issue <>", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueGreaterThan(Byte value) {
            addCriterion("issue >", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueGreaterThanOrEqualTo(Byte value) {
            addCriterion("issue >=", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLessThan(Byte value) {
            addCriterion("issue <", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLessThanOrEqualTo(Byte value) {
            addCriterion("issue <=", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueIn(List<Byte> values) {
            addCriterion("issue in", values, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotIn(List<Byte> values) {
            addCriterion("issue not in", values, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueBetween(Byte value1, Byte value2) {
            addCriterion("issue between", value1, value2, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotBetween(Byte value1, Byte value2) {
            addCriterion("issue not between", value1, value2, "issue");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Long value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Long value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Long value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Long value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Long> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Long> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Long value1, Long value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}