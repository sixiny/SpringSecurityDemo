package com.ysx.controller;

import com.ysx.pojo.User;
import com.ysx.service.LoginService;
import com.ysx.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ysx
 * @Date: 2023/03/03/15:54
 * @Description:
 */
@RestController
public class LoginController{

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult Login(@RequestBody User user){

        return loginService.Login(user);
    }


    @RequestMapping("/user/logout")
    public ResponseResult Logout(){
        return loginService.LoginOut();
    }

    @RequestMapping("/test")
    @PreAuthorize("hasAuthority('system:test:list11')")
    public String test(){
        return "test";
    }

}
