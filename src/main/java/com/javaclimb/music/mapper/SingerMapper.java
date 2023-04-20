package com.javaclimb.music.mapper;

import com.javaclimb.music.domain.Admin;
import com.javaclimb.music.domain.Singer;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface SingerMapper {

    //增加歌手信息
    @Insert("INSERT INTO singer(name,sex,pic,birth,location,introduction) VALUES(#{name},#{sex},#{pic},#{birth},#{location},#{introduction})")
    int insert(@Param("name") String name, @Param("sex") Byte sex, @Param("pic") String pic, @Param("birth") Date birth, @Param("location") String location, @Param("introduction") String introduction);

    //删除歌手信息
    @Delete("delete from singer where id=#{id}")
    int delete(@Param("id") Integer id);

    //修改
//    @Update("update singer set ")
//    @Update("update user_weight set t_weight=#{t_weight} where user_name=#{user_name} and time=#{time}")
//    int update(@Param("user_name") String user_name,@Param("t_weight") Integer t_weight,@Param("time") Date time);


    //按歌手名查询
    @Select("select * from singer where name=#{name}")
    Admin select_name(@Param("name") String name);
    //按性别查询
    @Select("selete * from singer where sex=#{sex}")
    Admin selete_sex(@Param("sex") Byte sex);
    //查询所有歌手
    @Select("selete * from singer")
    List<Singer> select_all();
}
