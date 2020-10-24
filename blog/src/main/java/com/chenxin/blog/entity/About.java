package com.chenxin.blog.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@ConfigurationProperties(prefix = "blog.about")
public class About {
    private String petname;
    private  String intro_1;
    private  String intro_2;
    private String images;
    private String qq;
    private List<String> loves=new ArrayList<>();
    private List<String> skill=new ArrayList<>();

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getName() {
        return petname;
    }

    public void setName(String name) {
        this.petname = name;
    }

    public String getIntro_1() {
        return intro_1;
    }

    public void setIntro_1(String intro_1) {
        this.intro_1 = intro_1;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getIntro_2() {
        return intro_2;
    }

    public void setIntro_2(String intro_2) {
        this.intro_2 = intro_2;
    }

    public List<String> getLoves() {
        return loves;
    }

    public void setLoves(List<String> loves) {
        this.loves = loves;
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "About{" +
                "petname='" + petname + '\'' +
                ", intro_1='" + intro_1 + '\'' +
                ", intro_2='" + intro_2 + '\'' +
                ", loves=" + loves +
                ", skill=" + skill +
                '}';
    }
}
