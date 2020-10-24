package com.chenxin.blog.entity;

import java.util.Arrays;

public class RequestLog {
    private Long id;
    private String url;
    private String ip;
    private String classMethod;
    /**
     * 获取的请求参数
     */
    private Object[] args;
    private String param;
    private String Return;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getReturn() {
        return Return;
    }

    public void setReturn(String aReturn) {
        Return = aReturn;
    }
    public String ObjToStr(Object[] args){
        boolean flag=false;
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            if(flag){
                sb.append(",");
            }else{
                flag=true;
            }
            sb.append(args[i]);
        }
        return sb.toString();
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "RequestLog{" +
                "url='" + url + '\'' +
                ", ip='" + ip + '\'' +
                ", classMethod='" + classMethod + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }

    public RequestLog(String url, String ip, String classMethod, Object[] args) {
        this.url = url;
        this.ip = ip;
        this.classMethod = classMethod;
        this.args = args;
    }
}

