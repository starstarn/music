package com.javaclimb.music.controller;

import com.javaclimb.music.domain.Singer;
import com.javaclimb.music.mapper.SingerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SingerController {

    @Autowired
    private SingerMapper singerMapper;


//    @PostMapping("/s_singer_all")
//    //@RequestMapping(value = "/s_singer_all",method = RequestMethod.POST)
//    public List<Singer> selSinger() {
//        List<Singer> Result = singerMapper.select_all();
//        if(Result != null) {
//            return Result;
//        }else {
//            return null;
//        }
//    }
}
