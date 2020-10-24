package com.chenxin.blog.mapper;

import com.chenxin.blog.entity.RequestLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    @Insert("insert into log values(#{id},#{url},#{ip},#{classMethod},#{param},#{Return})")
    int insertLog(RequestLog requestLog);
}
