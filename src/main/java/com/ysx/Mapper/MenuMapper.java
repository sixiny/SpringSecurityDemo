package com.ysx.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.ysx.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ysx
 * @Date: 2023/03/04/15:42
 * @Description:
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> getPermsByUserId(int id);
}
