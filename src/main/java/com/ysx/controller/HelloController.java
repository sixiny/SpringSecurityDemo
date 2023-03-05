package com.ysx.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ysx
 * @Date: 2023/03/03/11:21
 * @Description: 引入spring security以后加入了登录验证 他获取的是内存中缓存的账户密码 切换为从数据库获取
 * SPRING security最基本的就是从UserDetailService)中获取用户账户密码
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    //TODO 用户有test权限才能访问
    @PreAuthorize("hasAuthority('system:test:list11')")
    public String Hello(){
        return "hello";
    }

}
