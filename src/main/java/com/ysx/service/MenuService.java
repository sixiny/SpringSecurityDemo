package com.ysx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysx.pojo.Menu;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ysx
 * @Date: 2023/03/04/15:40
 * @Description:
 */
public interface MenuService extends IService<Menu> {

    List<String> getPerms(Integer id);
}
