package com.ysx.service;

import com.ysx.pojo.User;
import com.ysx.utils.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ysx
 * @Date: 2023/03/03/15:55
 * @Description:
 */
@Service
public interface LoginService {


    ResponseResult Login(User user);

    ResponseResult LoginOut();

}
