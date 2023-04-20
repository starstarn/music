package com.javaclimb.music.controller;

import com.javaclimb.music.domain.Singer;
import com.javaclimb.music.mapper.SingerMapper;
import com.javaclimb.music.util.Msg;
import com.javaclimb.music.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SingerController {

    @Autowired
    private SingerMapper singerMapper;


    //查询所有歌手信息
    @PostMapping("s_singer_all")
    //@RequestMapping(value = "/s_singer_all",method = RequestMethod.POST)
    public List<Singer> selSinger() {
        List<Singer> singerResult = singerMapper.select_all();
        if(singerResult != null) {
            return singerResult;
        }else {
            return null;
        }
    }

    //按姓名查询
    @PostMapping("s_singer_name")
    public Singer selName(@RequestBody Singer singer) {
        Singer sResult = singerMapper.select_name(singer.getName());
        if(sResult !=null) {
            return sResult;
        } else {
            return null;
        }
    }

    //按性别查询
    @PostMapping("s_singer_sex")
    public Singer selSex(@RequestBody Singer singer) {
        Singer sexResult = singerMapper.selete_sex(singer.getSex());
        if(sexResult !=null) {
            return sexResult;
        } else {
            return null;
        }
    }

    // 新增歌手信息
    @PostMapping("insert_singer")
    public Msg insertSinger(@RequestBody Singer singer) {
        try {
            singerMapper.insert(singer.getName(),singer.getSex(),singer.getPic(),singer.getBirth(),singer.getLocation(),singer.getIntroduction());
        } catch (Exception e) {
            return Result.error(-400,"出现异常");
        }
        return Result.success();
    }

    //删除歌手信息
    @PostMapping("delete_singer")
    public Msg deleteSinger(@RequestBody Singer singer) {
        try {
            singerMapper.delete(singer.getId());
        } catch (Exception e) {
            return Result.error(-400, "出现异常");
        }
        return Result.success();
    }



}
