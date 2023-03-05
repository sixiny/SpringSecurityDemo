package com.ysx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ysx.Mapper.UserMapper;
import com.ysx.pojo.LoginUser;
import com.ysx.pojo.User;
import com.ysx.service.MenuService;
import com.ysx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ysx
 * @Date: 2023/03/03/11:25
 * @Description:
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //认证
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUserName, s);
        User user = userService.getOne(lqw);
        if (user==null){
            throw new RuntimeException("用户名或密码错误");
        }

        //权限
        return new LoginUser(user, menuService.getPerms(user.getId().intValue()));
    }
}
