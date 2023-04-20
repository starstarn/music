package com.javaclimb.music.mapper;

import com.javaclimb.music.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//管理员Dao

//@Repository
@Mapper
public interface AdminMapper {
    //验证密码是否正确
    //public int verifyPassword(String username,String password);
    @Select("select * from admin where name=#{name}")
    Admin select(@Param("name") String name);
}
