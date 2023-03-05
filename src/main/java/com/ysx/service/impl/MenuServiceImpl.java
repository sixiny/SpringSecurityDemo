package com.ysx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysx.Mapper.MenuMapper;
import com.ysx.Mapper.UserMapper;
import com.ysx.pojo.Menu;
import com.ysx.pojo.User;
import com.ysx.service.MenuService;
import com.ysx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ysx
 * @Date: 2023/03/04/15:41
 * @Description:
// */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    public List<String> getPerms(Integer id) {
        return menuMapper.getPermsByUserId(id);
    }
}
