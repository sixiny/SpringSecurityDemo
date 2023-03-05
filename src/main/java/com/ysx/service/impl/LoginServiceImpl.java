package com.ysx.service.impl;

import com.ysx.pojo.LoginUser;
import com.ysx.pojo.User;
import com.ysx.service.LoginService;
import com.ysx.utils.JwtUtil;
import com.ysx.utils.RedisCache;
import com.ysx.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ysx
 * @Date: 2023/03/03/15:56
 * @Description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult Login(User user) {
        //TODO 登录验证
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token); //用户信息在spring security中以authentication存储
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
//
//         权限认证 将其存入redis缓存
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisCache.setCacheObject("login:"+userId,loginUser);
        HashMap<String, String> map = new HashMap<>();
        map.put("token", jwt);
        System.out.println(jwt);
        return new ResponseResult(200, "登录成功", map);
    }

    @Override
    public ResponseResult LoginOut() {
        // 删除redis
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser principal = (LoginUser) authentication.getPrincipal();
        redisCache.deleteObject(principal.getUser().getId().toString());
        return new ResponseResult(200, "退出成功");
    }
}
