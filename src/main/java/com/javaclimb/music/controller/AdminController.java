package com.javaclimb.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.music.domain.Admin;
import com.javaclimb.music.mapper.AdminMapper;
//import com.javaclimb.music.service.AdminService;
import com.javaclimb.music.util.Msg;
import com.javaclimb.music.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin
public class AdminController {

    @Autowired
    private AdminMapper adminMapper;

    //判断是否登录成功

    //登录
    @PostMapping("/admin/login/status")
    //@RequestMapping(value = "/admin/login/status",method = RequestMethod.POST)
    public Msg login(@RequestBody Admin admin) {
        try{
            Admin userResult = adminMapper.select(admin.getName());
            if(userResult==null){
                return Result.error(-202,"该用户不存在");
            }else {
                if(userResult.getPassword().equals(admin.getPassword())){
                    return Result.success();
                }else {
                    return Result.error(-203,"密码错误");
                }
            }
        }catch (Exception e){
            return Result.error(-400,"出现异常");
        }
    }



//    @RequestMapping(value = "/admin/login/status",method = RequestMethod.POST)
//    public Object loginStatus(HttpServletRequest request, HttpSession session){
//        JSONObject jsonObject = new JSONObject();
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        boolean flag = adminMapper.verifyPassword(name,password);
//        if(flag){
//            jsonObject.put(Consts.CODE,1);
//            jsonObject.put(Consts.MSG,"登录成功");
//            session.setAttribute(Consts.NAME,name);
//            return jsonObject;
//        }
//        jsonObject.put(Consts.CODE,0);
//        jsonObject.put(Consts.MSG,"用户名或密码错误");
//        return jsonObject;
//    }
}
