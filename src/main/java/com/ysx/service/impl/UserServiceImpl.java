package com.ysx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysx.Mapper.UserMapper;
import com.ysx.pojo.User;
import com.ysx.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ysx
 * @Date: 2023/03/03/10:58
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
